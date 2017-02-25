package precipitated.will.concurrent.producerandconsumer.version1;

import com.google.common.collect.Sets;
import org.apache.commons.collections.CollectionUtils;

import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 单例任务池
 * Created by will.wang on 2015/10/25.
 */
public class TaskPool {

    private static int poolSize = 10;

    private static ReadWriteLock lock = new ReentrantReadWriteLock();

    private static Set<BusinessTask> tasks = Sets.newHashSetWithExpectedSize(poolSize);

    private TaskPool() {
    }

    private static Set<BusinessTask> getTasks() {
        return tasks;
    }

    public static void addTask(BusinessTask task) throws Exception {
        lock.writeLock().lock();
        if(getTasks().size() >= poolSize) {
            throw new Exception("任务池满");
        }

        getTasks().add(task);
        System.out.println("生产task" + task.getId());
        lock.writeLock().unlock();
    }

    public static void processTask() throws Exception {
        lock.writeLock().lock();
        if(CollectionUtils.isEmpty(tasks)) {
            throw new Exception("任务池空");
        }

        for (BusinessTask task : tasks) {
            task.doSomething();
            tasks.remove(task);
            System.out.println("消费task" + task.getId());
            break;
        }

        lock.writeLock().unlock();
    }
}
