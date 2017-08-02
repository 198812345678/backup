package precipitated.will.concurrent.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by will on 17/6/20.
 */
public class ReleaseBeforeWait {

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                countDownLatch.countDown();
            }
        });


        thread.start();
        Thread.sleep(10000);
        countDownLatch.await();
        System.out.println("==========");
    }
}
