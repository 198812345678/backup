package precipitated.will.concurrent.runnableAndThread;

/**
 * Created by will.wang on 2016/9/7.
 * start方法和run方法区别
 */
public class RunnableSolution {

    static class MyThreadRunnable implements Runnable{

        private int i;

        MyThreadRunnable(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }

//    public static void main(String[] args) throws InterruptedException {
//        for (int i = 0; i < 10; i++) {
//            Thread myThreadRunnable = new Thread(new MyThreadRunnable(i));
//            myThreadRunnable.start();
//        }
//
//        Thread.sleep(50000);
//    }

    /**
     * 错误用法
     */
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            MyThreadRunnable myThreadRunnable = new MyThreadRunnable(i);
            myThreadRunnable.run();
        }

        Thread.sleep(50000);
    }
}
