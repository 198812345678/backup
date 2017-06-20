package precipitated.will.concurrent.producerandconsumer.version2;

import com.google.common.collect.Sets;
import org.apache.commons.collections.CollectionUtils;
import precipitated.will.concurrent.producerandconsumer.version1.BusinessTask;

import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by will.wang on 2015/10/25.
 */
public class TaskPool {

    private static int poolSize = 1;

    private static ReadWriteLock lock = new ReentrantReadWriteLock();

    private static Set<BusinessTask> tasks = Sets.newHashSetWithExpectedSize(poolSize);

    private TaskPool() {
    }

    private static Set<BusinessTask> getTasks() {
        return tasks;
    }

    public static void addTask(BusinessTask task) throws Exception {
        lock.writeLock().lock();
        System.out.println("生产task" + task.getId() + "获取队列锁-1");
        if(getTasks().size() >= poolSize) {
            throw new Exception("任务池满");
        }

        getTasks().add(task);
//        System.out.println("生产task" + task.getId());
        lock.writeLock().unlock();
        System.out.println("生产task" + task.getId() + "释放队列锁-2");
    }

    public static void processTask() throws Exception {
        lock.writeLock().lock();
        System.out.println("=========================消费task获取队列锁-1");
        if(CollectionUtils.isEmpty(tasks)) {
            throw new Exception("任务池空");
        }

        for (BusinessTask task : tasks) {
            task.doSomething();
            tasks.remove(task);
//            System.out.println("=================消费task" + task.getId());
            break;
        }

        lock.writeLock().unlock();
        System.out.println("=========================消费task释放队列锁-2");
    }

    public static boolean isFull() {
        lock.writeLock().lock();
        boolean result = tasks.size() >= poolSize;
        lock.writeLock().unlock();
        return result;
    }

    public static boolean isEmpty() {
        lock.writeLock().lock();
        boolean result = tasks.size() <= 0;
        lock.writeLock().unlock();
        return result;
    }
}
