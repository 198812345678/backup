package precipitated.will.designPattern.observer.qunarshare.javaapi;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by will.wang on 2016/11/13.
 */
public class TimeConsuingSubscriber implements Observer {

    private int i;

    public TimeConsuingSubscriber(Observable subject) {
        subject.addObserver(this);
    }

    public TimeConsuingSubscriber(int i, Observable subject) {
        this.i = i;
        subject.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        try {
            System.out.println(String.format("subscriber %s doUpdate", this.i));
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
