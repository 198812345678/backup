package precipitated.will.designPattern.observer.qunarshare.javaapi;

/**
 * Created by will.wang on 2016/11/13.
 */
public class Solution {

    public static void main(String[] args) {
        Publisher publisher = new Publisher();

        new TimeConsuingSubscriber(publisher);

//        new ExceptionSubscriber(publisher);
        for (int i = 0; i < 10; i++) {
            new TimeConsuingSubscriber(publisher);
        }
        new ExceptionSubscriber(publisher);


        long s = System.currentTimeMillis();
        publisher.publish();
        System.out.println(System.currentTimeMillis()-s);
    }
}
