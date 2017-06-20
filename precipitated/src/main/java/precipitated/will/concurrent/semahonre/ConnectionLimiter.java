package precipitated.will.concurrent.semahonre;

import java.util.concurrent.Semaphore;

/**
 * 主线程不会先结束？？？
 * http://www.javacodegeeks.com/2011/09/java-concurrency-tutorial-semaphores.html
 * Created by will.wang on 2015/12/28.
 */
public class ConnectionLimiter {

    private static Semaphore semaphore = new Semaphore(3);

    public static void acquireConnection() throws InterruptedException {
        semaphore.acquire();
        System.out.println(Thread.currentThread().getName() + "-acquireConnection");
    }

    public static void releaseConnection() {
        semaphore.release();
        System.out.println(Thread.currentThread().getName() + "-releaseConnection");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[4];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        ConnectionLimiter.acquireConnection();

                        Thread.sleep(3000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        ConnectionLimiter.releaseConnection();
                    }
                }
            });
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }

        System.out.println("main thread finish");

        System.out.println(1000);

//        System.exit(0);
    }
}
