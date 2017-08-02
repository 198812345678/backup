package precipitated.will.concurrent.cache;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by will on 17/6/29.
 */
public class BuffHandler {

    private static final AtomicInteger atoInt = new AtomicInteger(0);
    private static final AtomicInteger atoInt2 = new AtomicInteger(0);
    private static final FirstBuffQueue FIRST_BUFF_QUEUE = new FirstBuffQueue();
    private static final SecondBuffQueue SECOND_BUFF_QUEUE = new SecondBuffQueue();
    private static final ReentrantLock lock = new ReentrantLock();

    private static final ThreadPoolExecutor pool = new ThreadPoolExecutor(10, 20, 60, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(100),
            new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    return new Thread(r, "FirstBuffHandler-thread-" + atoInt.addAndGet(1));
                }
            },
            new RejectedExecutionHandler() {
                @Override
                public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                    System.out.println("!!!!!FirstBuffHandler rejected task!!!!");
                }
            }
    );


    private static final ThreadPoolExecutor pool2 = new ThreadPoolExecutor(10, 20, 60, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(100),
            new ThreadFactory() {
                @Override
                public Thread newThread(Runnable r) {
                    return new Thread(r, "SecondBuffQueueHandler-thread-" + atoInt2.addAndGet(1));
                }
            },
            new RejectedExecutionHandler() {
                @Override
                public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                    System.out.println("!!!!!SecondBuffQueueHandler rejected task!!!!");
                }
            }
    );

    /**
     * 如果一级缓冲区到达阈值, 则先批量刷新到二级缓冲区
     * 创建任务提交给pool
     * @param event
     */
    public static void handleEvent(BufEvent event) throws InterruptedException {
//        lock.lock();
//        try {
//            int firstBuffSize = FirstBuffQueue.size();
//            if(FirstBuffQueue.getSizeThreshold() < firstBuffSize) {
//                transfor();
//            }
//
            EventHandlerTask task = new EventHandlerTask(event);
            FirstBuffQueue.queue.put(task);
//        } finally {
//            lock.unlock();
//        }

        pool.execute(FIRST_BUFF_QUEUE);
//        pool2.execute(SECOND_BUFF_QUEUE);
    }

    private static void transfor() {
        int firstQueueSize = FirstBuffQueue.size();
        int size = SecondBuffQueue.getSizeThreshold()-SecondBuffQueue.size() > 0 ? SecondBuffQueue.getSizeThreshold()-SecondBuffQueue.size() : 0;
        int transforSize = FirstBuffQueue.queue.drainTo(SecondBuffQueue.queue, size);

//        System.out.println("FirstBuffQueue ==> SecondBuffQueue : " + transforSize);

        if(size <= FirstBuffQueue.size() && size != transforSize
                || size > FirstBuffQueue.size() && firstQueueSize != transforSize) {
            System.out.println("!!!! transfor faild !!!!");
        }
    }
}
