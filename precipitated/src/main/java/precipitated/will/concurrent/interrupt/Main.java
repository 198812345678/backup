package precipitated.will.concurrent.interrupt;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by will.wang on 2015/11/17.
 */
public class Main {

    public static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public static CountDownLatch countDownLatch = new CountDownLatch(2);
//    public static void main(String[] args) {
//        Thread task = new InterruptTestThread();
//        task.start();
//
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        task.interrupt();
//    }

    public static void main(String[] args) {

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                try {
                    lock.writeLock().lock();
//                    Thread.currentThread().interrupt();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.writeLock().unlock();
                    System.out.println("1 finally");
                    countDownLatch.countDown();

                }
            }
        };

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                try {
//                    Thread.currentThread().interrupt();
                    lock.writeLock().lock();
//                    while (true) {
//                        System.out.println("ininiin");
//                    }
//                    sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                    lock.writeLock().unlock();
                    System.out.println("2 finally");
                }
            }
        };

        thread1.start();
        System.out.println("=============");
        thread2.start();
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        thread2.stop();
        System.out.println("thread2.interrupt()");

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
