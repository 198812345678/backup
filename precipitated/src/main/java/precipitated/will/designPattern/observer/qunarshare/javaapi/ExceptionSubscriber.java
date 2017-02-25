package precipitated.will.designPattern.observer.qunarshare.javaapi;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by will.wang on 2016/11/13.
 */
public class ExceptionSubscriber implements Observer {

    public ExceptionSubscriber(Observable subject) {
        subject.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new RuntimeException("any RuntimeException exception");
    }
}
