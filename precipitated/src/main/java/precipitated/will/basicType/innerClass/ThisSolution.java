package precipitated.will.basicType.innerClass;

/**
 * Created by will.wang on 2017/2/8.
 */
public class ThisSolution {

    public static void main(String[] args) {
        new ThisSolution().doSomething();
    }

    public void doSomething() {
        new Runnable() {
            @Override
            public void run() {
                System.out.println(this);
            }

            @Override
            public String toString() {
                return "new Runnable";
            }
        }.run();

        System.out.println(this);
    }
}
