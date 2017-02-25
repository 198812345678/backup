package precipitated.will.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Created by will.wang on 2017/2/8.
 */
public class BasicSolution {

    public static void main(String[] args) {
        Num42 i = ()
                ->
                4;

        int n = 9;
        Num42[] a = new Num42[] {() -> n, () -> n+1};
//        System.out.println(i.getI());

        new BasicSolution().doSomething();
    }

    interface Num42 {
        int getI();
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
