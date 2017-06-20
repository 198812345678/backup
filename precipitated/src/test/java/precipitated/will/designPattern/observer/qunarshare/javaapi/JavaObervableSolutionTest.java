package precipitated.will.designPattern.observer.qunarshare.javaapi;

import org.junit.Test;

public class JavaObervableSolutionTest {

    @Test
    public void testCommonSubscriber() {
        Publisher publisher = new Publisher();
        new CommonSubscriber(publisher);

        publisher.publish();
    }

    @Test
    public void testTimeConsumingSubscriber() {
        Publisher publisher = new Publisher();

        for (int i = 0; i < 10; i++) {
            new TimeConsuingSubscriber(publisher);
        }

        long s = System.currentTimeMillis();
        publisher.publish();
        System.out.println(System.currentTimeMillis()-s);
    }

    @Test
    public void testExceptionSubscriber() {
        Publisher publisher = new Publisher();

        for (int i = 0; i < 10; i++) {
            new TimeConsuingSubscriber(publisher);
        }
        new ExceptionSubscriber(publisher);

        long s = System.currentTimeMillis();
        publisher.publish();
        System.out.println(System.currentTimeMillis()-s);
    }

}