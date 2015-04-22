package precipitated.will;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * executor一直没有停止
 * Created by will.wang on 2015/4/15.
 */
public class SynchronizedTest implements Callable{
    private Syn syn;

    public SynchronizedTest(Syn syn) {
        this.syn = syn;
    }

    @Override
    public Object call() throws Exception {

        if(syn.getI() == 0) {
            syn.hello();
        } else {
            syn.sleep();
        }
        return null;
    }



    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Syn syn = new Syn();
        syn.setI(1);
        SynchronizedTest test1 = new SynchronizedTest(syn);
        executor.submit(test1);

        Thread.sleep(3000);
        Syn syn2 = new Syn();
        syn2.setI(0);
        SynchronizedTest test2 = new SynchronizedTest(syn2);
        executor.submit(test2);

        System.out.println("=======END======");
    }
}

class Syn{
    private int i;

    public int getI() {
        return i;
    }

    public synchronized void hello() {
        System.out.println("=====hello=========");
    }

    public synchronized void sleep() throws InterruptedException {
        System.out.println("==========sleep=============");
        Thread.sleep(10000);
        System.out.println("==========sleep end=============");
    }

    public void setI(int i) {
        this.i = i;
    }
}
