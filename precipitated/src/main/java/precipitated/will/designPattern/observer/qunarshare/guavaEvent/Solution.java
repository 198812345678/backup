package precipitated.will.designPattern.observer.qunarshare.guavaEvent;

import com.google.common.eventbus.EventBus;
import precipitated.will.event.GuavaEventBus;

/**
 * Created by will.wang on 2016/11/15.
 */
public class Solution {

    public static void main(String[] args) {
        final EventBus eventBus = MyEventBus.eventBus;

        Subcriber subcriber = new Subcriber();

        eventBus.register(subcriber);

        final Event event = new Event();

        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    eventBus.post(event);

                }
            });

            thread.start();
        }
    }
}
