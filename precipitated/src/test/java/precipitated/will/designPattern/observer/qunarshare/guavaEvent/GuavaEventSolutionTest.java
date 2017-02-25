package precipitated.will.designPattern.observer.qunarshare.guavaEvent;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import static org.junit.Assert.*;

public class GuavaEventSolutionTest {

    @Test
    public void testCommonEvent() {
        final EventBus eventBus = new EventBus();

        Subcriber subcriber = new Subcriber();

        eventBus.register(subcriber);

        final Event event = new Event();
        eventBus.post(event);
    }

    @Test
    public void testException() {
        final EventBus eventBus = new EventBus();

        Subcriber subcriber = new Subcriber();
        ExceptionSubscriber exceptionSubscriber = new ExceptionSubscriber();

        eventBus.register(subcriber);
        eventBus.register(exceptionSubscriber);

        final Event event = new Event();
        eventBus.post(event);
    }

    @Test
    public void testTimeConsuming() {
        final EventBus eventBus = new EventBus();

        for (int i = 0; i < 10; i++) {
            LongTimeSubscriber subscriber = new LongTimeSubscriber();
            eventBus.register(subscriber);
        }

        final Event event = new Event();
        long s = System.currentTimeMillis();
        eventBus.post(event);
        System.out.println(System.currentTimeMillis() - s);
    }

    @Test
    public void testTimeConsumingAsyncEvent() throws InterruptedException {
        Executor executor = Executors.newFixedThreadPool(10);
        AsyncEventBus eventBus = new AsyncEventBus(executor);

        int a = 10;
        CountDownLatch countDownLatch = new CountDownLatch(a);
        for (int i = 0; i < a; i++) {
            LongTimeSubscriber subscriber = new LongTimeSubscriber(countDownLatch);
            eventBus.register(subscriber);
        }

        final Event event = new Event();

        long s = System.currentTimeMillis();
        eventBus.post(event);
        countDownLatch.await();
        System.out.println(System.currentTimeMillis() - s);
    }

    @Test
    public void testExceptionAsycEvent() throws InterruptedException {
        Executor executor = Executors.newFixedThreadPool(10);
        AsyncEventBus eventBus = new AsyncEventBus(executor);

        int a = 10;
        CountDownLatch countDownLatch = new CountDownLatch(a);

        for (int i = 0; i < a-1; i++) {
            Subcriber subscriberi = new Subcriber(countDownLatch);
            eventBus.register(subscriberi);
        }

        ExceptionSubscriber subscriber = new ExceptionSubscriber(countDownLatch);
        eventBus.register(subscriber);

        final Event event = new Event();
        eventBus.post(event);

        countDownLatch.await();
    }

}