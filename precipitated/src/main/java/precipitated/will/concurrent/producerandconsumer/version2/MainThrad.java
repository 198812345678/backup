package precipitated.will.concurrent.producerandconsumer.version2;

/**
 * 多个生产者线程和多个消费者线程
 * Created by will.wang on 2015/10/25.
 */
public class MainThrad {
    public static void main(String[] args) {

        TaskPoolWithBlockQueue taskPool = new TaskPoolWithBlockQueue();

        //生产者
        Producer producer = new Producer(taskPool);
        producer.produceConcurrently();

        //消费者
        Consumer consumer = new Consumer(taskPool);
        consumer.processConcurrently();
    }
}
