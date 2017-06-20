package precipitated.will.concurrent.threadLocal;

/**
 * http://my.oschina.net/clopopo/blog/149368?fromerr=vyy5ggcJ
 * Created by will.wang on 2015/12/22.
 */
public class ThreadLocalBasicTest {

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
      @Override
      public Integer initialValue() {
          return 0;
      }
    };

    static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                Integer value = threadLocal.get();
                threadLocal.set(++value);
            }
            System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
        }
    }

    public static void main(String[] args) {
        threadLocal.set(499);
        MyThread[] threads = new MyThread[10];
        for (MyThread thread : threads) {
            thread = new MyThread();
            thread.start();
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
