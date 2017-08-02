package precipitated.will.concurrent.cache;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by will on 17/6/29.
 */
public class BufEvent {

    private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger(0);

    private int eventId;

    public BufEvent() {
        eventId = ATOMIC_INTEGER.addAndGet(1);
    }

    public int getEventId() {
        return eventId;
    }
}
