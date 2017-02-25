package precipitated.will.designPattern.observer.qunarshare.javaapi;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by will.wang on 2016/11/20.
 */
public class CommonSubscriber implements Observer {

    public CommonSubscriber(Observable subject) {
        subject.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(String.format("subscriber doUpdate"));
    }
}
