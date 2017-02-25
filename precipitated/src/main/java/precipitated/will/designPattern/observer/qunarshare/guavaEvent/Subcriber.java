package precipitated.will.designPattern.observer.qunarshare.guavaEvent;

import com.google.common.eventbus.Subscribe;

import java.util.concurrent.CountDownLatch;

/**
 * Created by will.wang on 2016/11/15.
 */
public class Subcriber {

    private CountDownLatch countDownLatch;

    public Subcriber() {
    }

    public Subcriber(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Subscribe
    public void doSomething(Event event) throws InterruptedException {
        try {
            System.out.println("do something !");
        } finally {
            if(countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }
}
