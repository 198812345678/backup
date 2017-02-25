package precipitated.will.concurrent.producerandconsumer.version2;

import precipitated.will.concurrent.producerandconsumer.version1.BusinessTask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by will.wang on 2015/10/25.
 */
public class Producer {

    private TaskPoolWithBlockQueue taskPool;

    public Producer(TaskPoolWithBlockQueue taskPool) {
        this.taskPool = taskPool;
    }

    public void produce() {
        BusinessTask task = new BusinessTask();
        try {
            taskPool.offer(task);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void produceConcurrently() {
        ExecutorService executorService = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 20; i++) {
            executorService.submit(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    produce();
                    return null;
                }
            });
        }

        executorService.shutdown();
    }
}
