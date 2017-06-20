package precipitated.will.concurrent.threadLocal;

import org.slf4j.MDC;

import java.util.concurrent.CountDownLatch;

/**
 * Created by will.wang on 2016/9/7.
 */
public class MultiThreadMDC {

    private static String key = "key";

    static class ThreadMDC extends Thread{

        private CountDownLatch countDownLatch;

        ThreadMDC(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + ":" + MDC.get(key));
            } finally {
                countDownLatch.countDown();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MDC.put(key, "5");

        int count = 10;

        CountDownLatch countDownLatch = new CountDownLatch(count);

        for (int i = 0; i < count; i++) {
            ThreadMDC threadMDC = new ThreadMDC(countDownLatch);
            threadMDC.start();
        }

        countDownLatch.await();
        System.out.println("===============================");
    }
}
