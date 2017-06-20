package precipitated.will.concurrent.interrupt;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class InterruptTestThreadTest {

    ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2, 4, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10));

    @Test
    public void test() {
        Thread thread = new InterruptTestThread();
        FutureTask task = new FutureTask(thread, void.class);
        poolExecutor.execute(task);

        thread.interrupt();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}