package precipitated.will.event;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import javax.swing.event.ChangeEvent;
import java.util.EventObject;

/**
 * Created by will.wang on 2015/5/12.
 */
public class GuavaEventBus {
    public static EventBus eventBus = new EventBus();

    public static void main(String[] args) {

        eventBus.register(new Subscriber());

        EventSource1 eventSource1 = new EventSource1();

        MyEvent event = new MyEvent(eventSource1);
        event.happen();
//        System.out.println(event.test);
//
//        SubMyEvent subMyEvent = new SubMyEvent(eventSource1);
//        subMyEvent.happen();
//        System.out.println(subMyEvent.test);
    }
}

class Subscriber {
    @Subscribe public void myEventSubscriber(MyEvent event) {
        System.out.println("get MyEvent");
    }

    @Subscribe public void changeEventSubscriber(ChangeEvent event) {
        System.out.println("get ChangeEvent");
    }

    @Subscribe private void deadEventSubscriber(DeadEvent event) {
        System.out.println("get deadEvent");
    }
}

class EventSource1 {
    private int i;

    public void setI(int i) {
        this.i = i;
    }
}

class MyEvent extends EventObject{
    private Object source;

    protected int test = 1;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public MyEvent(EventSource1 source) {
        super(source);
        this.source = source;
    }

    protected void happen() {
        ((EventSource1)this.source).setI(4);
        GuavaEventBus.eventBus.post(this);
    }
}

class SubMyEvent extends MyEvent {

    public int test = 2;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public SubMyEvent(EventSource1 source) {
        super(source);
    }

    public void happen() {
        System.out.println("SubMyEvent happen");
    }
}
