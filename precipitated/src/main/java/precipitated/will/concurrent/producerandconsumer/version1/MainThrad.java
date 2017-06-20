package precipitated.will.concurrent.producerandconsumer.version1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 只是启动生产者线程和消费者线程两个线程，每个线程循环生产和消费，不是真正的生产者消费者，应该是多个生产者线程和多个消费者线程
 * Created by will.wang on 2015/10/25.
 */
public class MainThrad {
    public static void main(String[] args) {

        //生产者线程
        producerThread();

        //消费者线程
        consumerThread();
    }

    private static void consumerThread() {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                for (int i = 0; i < 50; i++) {
                    Consumer consumer = new Consumer();
                    consumer.process();
                }
                return null;
            }
        });

        executorService.shutdownNow();

    }

    private static void producerThread() {

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                for (int i = 0; i < 50; i++) {
                    Producer producer = new Producer();
                    producer.produce();
                }
                return null;
            }
        });

        executorService.shutdownNow();
    }
}
