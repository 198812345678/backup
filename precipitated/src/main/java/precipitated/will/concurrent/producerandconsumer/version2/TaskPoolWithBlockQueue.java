package precipitated.will.concurrent.producerandconsumer.version2;

import precipitated.will.concurrent.producerandconsumer.version1.BusinessTask;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 调用isEmpty或者isFull前已经lock了，所以这两个方法内不用加锁
 * 首先明确，任务池是需要同步的资源，所以lock应该加在taskpool上，根据condition来await和signal的前提是线程拥有了lock（否则抛java.lang.IllegalMonitorStateException ），
 * 所以lock、await、signal等操作都是在taskpool层面进行的，而不是在producer和consumer层面做这些操作
 * Created by will.wang on 2015/10/28.
 */
public class TaskPoolWithBlockQueue {

    private int maxSize = 10;

    private ArrayBlockingQueue queue = new ArrayBlockingQueue(maxSize);

    private ReentrantLock lock = new ReentrantLock();

    private Condition spaceCondition = lock.newCondition();
    private Condition productCondition = lock.newCondition();

    private static TaskPoolWithBlockQueue taskPool = new TaskPoolWithBlockQueue();

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public boolean isFull() {
        return queue.size() >= maxSize;
    }

    public void offer(BusinessTask task) {
        lock.lock();
        try {
            boolean flag = false;
            while (isFull()) {
                flag = true;
//                System.out.println(Thread.currentThread().getName() + " 生产者等待");
                spaceCondition.await();
            }

            if(flag) {
//                System.out.println(Thread.currentThread().getName() + "生产者停止等待");
            }

            System.out.println(Thread.currentThread().getName() + " offer task-" + task.getId());
            queue.offer(task);
            productCondition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void poll() {
        lock.lock();
        try {
            boolean flag = false;
            while (isEmpty()) {
                flag = true;
//                System.out.println("***************************************" + Thread.currentThread().getName() + " 消费者等待");
                productCondition.await();
            }

            if(flag) {
//                System.out.println("***************************************" + Thread.currentThread().getName() + "生产者停止等待");
            }

            BusinessTask task = (BusinessTask)queue.poll();
            System.out.println("***************************************" + Thread.currentThread().getName() + " poll task-" + task.getId());

            spaceCondition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
