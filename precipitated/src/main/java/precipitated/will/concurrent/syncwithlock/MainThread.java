package precipitated.will.concurrent.syncwithlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 如果使用shutdownnow会导致sleep中的线程强制中断，抛出异常
 * Created by will.wang on 2015/10/31.
 */
public class MainThread {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executorService.submit(new Job());
        }

        executorService.shutdown();
    }
}
