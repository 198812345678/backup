package precipitated.will.designPattern.singleton;

/**
 * Created by will on 17/6/21.
 */
public class Singleton1 {

    private static volatile Singleton1 ins;

    private Singleton1() {

    }

    public static Singleton1 getIns() {
        synchronized (ins) {
            if(ins == null) {
                ins = new Singleton1();
            }
        }
        return ins;
    }
}
