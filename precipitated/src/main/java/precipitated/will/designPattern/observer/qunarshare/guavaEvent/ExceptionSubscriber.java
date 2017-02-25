package precipitated.will.designPattern.observer.qunarshare.guavaEvent;

import com.google.common.eventbus.Subscribe;

import java.util.concurrent.CountDownLatch;

/**
 * Created by will.wang on 2016/11/15.
 */
public class ExceptionSubscriber {

    private CountDownLatch countDownLatch;

    public ExceptionSubscriber() {
    }

    public ExceptionSubscriber(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Subscribe
    public void doSomething(Event event) throws Exception {
        try {
            throw new Exception("exception !!");
        } finally {
            if(countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }
}
