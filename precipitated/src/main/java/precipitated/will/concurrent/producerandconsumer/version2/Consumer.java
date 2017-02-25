package precipitated.will.concurrent.producerandconsumer.version2;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by will.wang on 2015/10/25.
 */
public class Consumer {

    private TaskPoolWithBlockQueue taskPool;

    public Consumer(TaskPoolWithBlockQueue taskPool) {
        this.taskPool = taskPool;
    }

    public void process() {
        try {
            taskPool.poll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void processConcurrently() {
        ExecutorService executorService = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 20; i++) {
            executorService.submit(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    process();
                    return null;
                }
            });
        }

        executorService.shutdown();
    }
}
