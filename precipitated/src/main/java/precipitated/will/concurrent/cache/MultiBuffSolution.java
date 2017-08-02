package precipitated.will.concurrent.cache;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by will on 17/6/29.
 * 10000个线程向一级缓存提交任务
 *
 */
public class MultiBuffSolution {

    private static final AtomicInteger count = new AtomicInteger(0);

    private static final long startTime = System.currentTimeMillis();

    public static void main(String[] args) throws InterruptedException {


        while (true) {
//        for (int i = 0; i < 10; i++) {

            doWork();
            Thread.sleep(300);

        }

    }


    private static void doWork() {
        for (int i = 0; i < 1000; i++) {
            final int c = i;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    BufEvent event = new BufEvent();
                    try {
                        BuffHandler.handleEvent(event);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    System.out.println("提交任务" + event.getEventId() + "完成");
                }
            });

            thread.start();
            count.addAndGet(1);
            try {
                long time = (System.currentTimeMillis()-startTime) / 1000;
                if(time == 0) {
//                    System.out.println("so short time!!!");
                } else {

                    long average = count.get() / time;
//                    System.out.println("========average inthrought = " + average);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
