package precipitated.will.concurrent.cache;

import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by will on 17/6/29.
 */
public class FirstBuffQueue implements Runnable{

    public static final BlockingQueue<EventHandlerTask> queue = new LinkedBlockingQueue<EventHandlerTask>(1000);

    private static final int sizeThreshold = 750;

    public static boolean offer(EventHandlerTask event) {
        return queue.offer(event);
    }

    public static int size() {
        return queue.size();
    }

    public static int getSizeThreshold() {
        return sizeThreshold;
    }

    @Override
    public void run() {
        List<EventHandlerTask> list = Lists.newArrayList();
        queue.drainTo(list, 10);
        if(CollectionUtils.isEmpty(list)) {
            return;
        }
        for (EventHandlerTask task : list) {
            task.doHandle();
        }
    }
}
