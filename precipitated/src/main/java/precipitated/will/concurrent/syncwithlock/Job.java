package precipitated.will.concurrent.syncwithlock;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by will.wang on 2015/10/31.
 */
public class Job implements Callable{

    private static AtomicInteger jobId = new AtomicInteger(0);

    @Override
    public Object call() throws Exception {
        int id = jobId.getAndAdd(1);
        System.out.println(Thread.currentThread().getName() + ": going to pringt job " + id);
        PrintQueue.printJob(id);
        System.out.println(Thread.currentThread().getName() + ": pringt job finished " + id);
        return null;
    }
}
