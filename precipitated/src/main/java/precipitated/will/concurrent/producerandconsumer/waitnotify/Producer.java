package precipitated.will.concurrent.producerandconsumer.waitnotify;

import java.util.Vector;

/**
 * Created by will.wang on 2016/1/1.
 */
public class Producer implements Runnable {
    private final Vector sharedVector;
    private final int SIZE;

    public Producer(Vector sharedVector, int SIZE) {
        this.sharedVector = sharedVector;
        this.SIZE = SIZE;
    }

    @Override
    public void run() {
        for (int i = 0; i < 7; i++) {
            System.out.println("producer " + Thread.currentThread().getName() + " produced " + produce(i));
        }
    }

    private int produce(int produceId) {
        while (sharedVector.size() == SIZE) {
            try {
                synchronized (sharedVector) {
                    System.out.println("Queue is full " + produceId + "is waiting , size: " + sharedVector.size());
                    sharedVector.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        synchronized (sharedVector) {
            sharedVector.add(produceId);
            sharedVector.notifyAll();
        }

        return produceId;
    }
}
