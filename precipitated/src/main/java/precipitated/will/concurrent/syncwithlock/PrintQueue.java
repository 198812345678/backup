package precipitated.will.concurrent.syncwithlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by will.wang on 2015/10/31.
 */
public class PrintQueue {

    private static final ReentrantLock lock = new ReentrantLock();

    public static void printJob(int jobId) {
        lock.lock();

        try {
            long duration = (long)(10000 * Math.random());
            System.out.println(Thread.currentThread().getName() + "print job " + jobId + " duration= " + (duration/1000) + " seconds");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
