package precipitated.will.concurrent.producerandconsumer.condition;

import com.google.common.collect.Lists;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * pendingLines用来判断是否还会有数据插入
 * 使用signal死锁了，还是使用signalall
 * 判断是否需要await，使用while是对的，使用if貌似不对，原因是当其他线程调用signalAll后，本线程被唤醒，但是所需条件不一定满足，所以被唤醒后还要判断
 * Created by will.wang on 2015/10/31.
 */
public class Buffer {

    private LinkedList<String> buffer;

    private ReentrantLock lock;

    private boolean pendingLines;

    private Condition space;

    private Condition lines;

    private int maxSize;

    public Buffer(int maxSize) {
        lock = new ReentrantLock();
        space = lock.newCondition();
        lines = lock.newCondition();
        buffer = new LinkedList<String>();
        this.maxSize = maxSize;
    }

    public boolean isPendingLines() {
        return pendingLines || buffer.size() > 0;
    }

    public void setPendingLines(boolean pendingLines) {
        this.pendingLines = pendingLines;
    }

    public void insert(String line) {
        lock.lock();

        try {
            boolean flag = false;
            while (buffer.size() == maxSize) {
                flag = true;
                System.out.println(Thread.currentThread().getName() + " insert await ");
                space.await();
            }

            if(flag) {
                System.out.println(Thread.currentThread().getName() + " insert signaled ");
            }

            buffer.offer(line);
            System.out.println(Thread.currentThread().getName() + " insert line " + buffer.size());
            lines.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public String get() {
        String line = null;

        lock.lock();

        try {
            boolean flag = false;
            while (buffer.size() == 0 && isPendingLines()) {
                flag = true;
                System.out.println("***********************" + Thread.currentThread().getName() + " get await ");
                lines.await();
            }
            if(flag) {
                System.out.println("***********************" + Thread.currentThread().getName() + " get signaled ");
            }
            if(isPendingLines()) {
                line = buffer.poll();
                System.out.println(Thread.currentThread().getName() + " get line " + buffer.size());
                space.signalAll();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        return line;
    }
}
