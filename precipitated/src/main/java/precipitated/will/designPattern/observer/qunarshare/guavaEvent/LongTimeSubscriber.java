package precipitated.will.designPattern.observer.qunarshare.guavaEvent;

import com.google.common.eventbus.Subscribe;

import java.util.concurrent.CountDownLatch;

/**
 * Created by will.wang on 2016/11/16.
 */
public class LongTimeSubscriber {

    private CountDownLatch countDownLatch;

    public LongTimeSubscriber() {
    }

    public LongTimeSubscriber(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Subscribe
    public void doTimeConsumingJob(Event event) {
        try {
            try {
                Thread.sleep(1000);
            } catch (Throwable e) {
                e.printStackTrace();
            }
            System.out.println("time-consumimng job done !");
        } finally {
            if(countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }
}
