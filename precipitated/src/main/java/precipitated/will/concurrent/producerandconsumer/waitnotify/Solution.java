package precipitated.will.concurrent.producerandconsumer.waitnotify;

import java.util.Vector;

/**
 * Created by will.wang on 2016/1/1.
 */
public class Solution {

    public static void main(String[] args) {
        Vector vector = new Vector();
        int SIZE = 4;
        Thread producer = new Thread(new Producer(vector, SIZE));
        Thread consumer = new Thread(new Consumer(vector, SIZE));

        producer.start();
        consumer.start();
    }
}
