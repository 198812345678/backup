package precipitated.will.concurrent.producerandconsumer.waitnotify;

import java.util.Vector;

/**
 * Created by will.wang on 2016/1/1.
 */
public class Consumer implements Runnable {
    private final Vector sharedVector;
    private final int SIZE;

    public Consumer(Vector sharedVector, int SIZE) {
        this.sharedVector = sharedVector;
        this.SIZE = SIZE;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("consumer " + Thread.currentThread().getName() + " consume " + consume());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private int consume() {
        while (sharedVector.size() == 0) {
            try {
                synchronized (sharedVector) {
                    System.out.println("Queue is empty consumer is waiting , size: " + sharedVector.size());
                    sharedVector.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int i = -1;
        synchronized (sharedVector) {
            i = (Integer)sharedVector.remove(0);
            sharedVector.notifyAll();
        }

        return i;
    }
}
