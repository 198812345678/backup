package precipitated.will.concurrent.threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * main 方法运行：线程池要显示关闭，否则主线程会一直存在
 * test ：运行test主线程会马上关闭
 * Created by will.wang on 2015/12/28.
 */
public class SubThreadInterrupt {

    private static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 2, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2));

    public static void main(String[] args) throws InterruptedException {

        final int sleep1 = 1000;
        final int sleep2 = 5000;

        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Thread[] threads = new Thread[2];
        for (int i = 0; i < threads.length; i++) {
            final int finalI = i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        long sleep = finalI * 3000L;
                        System.out.println(Thread.currentThread().getName() + " start");
                        Thread.sleep(finalI);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        countDownLatch.countDown();
                        System.out.println(Thread.currentThread().getName() + " finish " + System.currentTimeMillis());
                    }
                }
            });
        }

        for (int i = 0; i < threads.length; i++) {
            threadPool.execute(threads[i]);
        }

//        countDownLatch.await();
//        threadPool.shutdownNow();
        System.out.println("main thread finish " + System.currentTimeMillis());
    }

    public static void subThreadTest() {

        final int sleep1 = 1000;
        final int sleep2 = 5000;

        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Thread[] threads = new Thread[2];
        for (int i = 0; i < threads.length; i++) {
            final int finalI = i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        long sleep = finalI * 3000L;
                        System.out.println(Thread.currentThread().getName() + " start");
                        Thread.sleep(finalI);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        countDownLatch.countDown();
                        System.out.println(Thread.currentThread().getName() + " finish " + System.currentTimeMillis());
                    }
                }
            });
        }

        for (int i = 0; i < threads.length; i++) {
            threadPool.execute(threads[i]);
        }

//        countDownLatch.await();
//        threadPool.shutdownNow();
        System.out.println("main thread finish " + System.currentTimeMillis());
    }
}
