package precipitated.will.concurrent.producerandconsumer.version2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by will.wang on 2015/10/27.
 */
public class Notifier {
    private static final ReentrantLock lock = new ReentrantLock();
    public static Condition spaceCondition = lock.newCondition();
    public static Condition productCondition = lock.newCondition();
}
