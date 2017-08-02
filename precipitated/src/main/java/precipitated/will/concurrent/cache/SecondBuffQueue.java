package precipitated.will.concurrent.cache;

import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by will on 17/6/29.
 */
public class SecondBuffQueue implements Runnable{


    public static final BlockingQueue<EventHandlerTask> queue = new LinkedBlockingQueue<EventHandlerTask>(100);
    private static final int sizeThreshold = 75;


    public static int getSizeThreshold() {
        return sizeThreshold;
    }

    public static int size() {
        return queue.size();
    }

    @Override
    public void run() {
        List<EventHandlerTask> list = Lists.newArrayList();
//        System.out.println("==============size=" + queue.size());
        queue.drainTo(list, 10);
        if(CollectionUtils.isEmpty(list)) {
//        System.out.println("==============size=" + queue.size());
            return;
        }
        for (EventHandlerTask task : list) {
            task.doHandle();
        }
    }
}
