package precipitated.will.designPattern.observer.qunarshare.javaapi;

import java.util.Observable;

/**
 * Created by will.wang on 2016/11/13.
 */
public class Publisher extends Observable {


    public Publisher() {

    }
    /**
     * Observable使用vector维护观察者，逆序notify，但是不应依赖顺序
     */
    public void publish() {
        setChanged();
        notifyObservers();
    }
}
