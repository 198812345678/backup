package precipitated.will.designPattern.observer;

import java.util.Vector;

/**
 * Created by will.wang on 2015/5/13.
 */
public class ObserverPattern {

    public static void main(String[] args) {
        Subject subject = new SpecificSubject();
        subject.addObserver(new SpecificObserver1());
        subject.addObserver(new SpecificObserver2());
        subject.doSomething();
    }
}

abstract class Subject {

    private Vector<Observer> observers = new Vector<Observer>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    protected void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    protected void doSomething() {

    }

}

interface Observer {

    void update();
}


class SpecificSubject extends Subject {
    public void doSomething() {
        System.out.println("具体事件发生");
        notifyObservers();
    }
}

class SpecificObserver1 implements Observer {

    @Override
    public void update() {
        System.out.println("SpecificObserver1 处理事件");
    }
}

class SpecificObserver2 implements Observer {

    @Override
    public void update() {
        System.out.println("SpecificObserver2 处理事件");
    }
}