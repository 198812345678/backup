package precipitated.will.concurrent.interrupt;

import java.util.concurrent.Callable;

/**
 * Created by will.wang on 2015/11/17.
 */
public class InterruptTestThread extends Thread {

    @Override
    public void run() {
        while (true) {
            if(this.isInterrupted()) {
                System.out.println(this.getName() + "is interrupted");
                return;
            }

            for (int i = 0; i < 4; i++) {
                if(i % 2 == 0) {
                    System.out.println(this.getName() + " is printting a 偶数 " + i);
                }
            }
        }
    }
}
