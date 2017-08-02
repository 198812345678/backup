package precipitated.will.designPattern.singleton;

/**
 * Created by will on 17/6/21.
 */
public class Singleton3 {

    private static Singleton3 ins = new Singleton3();

    private Singleton3() {

    }

    public static Singleton3 getIns() {
        return ins;
    }
}
