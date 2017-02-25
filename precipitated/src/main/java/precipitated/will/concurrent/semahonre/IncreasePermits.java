package precipitated.will.concurrent.semahonre;

import java.util.concurrent.Semaphore;

/**
 * 即使没有acquire，release也会导致信号量增强
 * Created by will.wang on 2015/12/28.
 */
public class IncreasePermits {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(0);

        semaphore.release();
        semaphore.release();
        semaphore.release();
        semaphore.release();

        semaphore.acquire();
        System.out.println("acquire finish");

        semaphore.acquire();
        System.out.println("release finish");

        semaphore.acquire();
        System.out.println("release finish");
    }
}
