package precipitated.will.designPattern.singleton;

/**
 * Created by will on 17/6/21.
 */
public class Singleton2 {

    private Singleton2() {

    }

    private static class InsHolder {
        static Singleton2 ins = new Singleton2();
    }

    public static Singleton2 getIns() {
        return InsHolder.ins;
    }
}
