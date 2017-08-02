package precipitated.will.concurrent.cache;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by will on 17/6/29.
 */
public class EventHandlerTask {

    private BufEvent event;
    private static final AtomicInteger count = new AtomicInteger(0);
    private static final long startTime = System.currentTimeMillis();

    public EventHandlerTask(BufEvent bufEvent) {
        this.event = bufEvent;
    }

    public void doHandle() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + "handled event " + event.getEventId());
        try {
            count.addAndGet(1);
            long average = count.get() / ((System.currentTimeMillis()-startTime) / 1000);
            System.out.println("average outthrought = " + average);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
