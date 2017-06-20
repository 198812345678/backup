package precipitated.will.concurrent.visibility;

/**
 * Runable.run()不是新启动一个线程，用Thread才会新启动线程
 * http://aswang.iteye.com/blog/1744230
 * 重排序没有复现
 * Created by will.wang on 2016/1/7.
 */
public class Solution {

    public static boolean ready;
    public static int number;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new ShareThread()).start();
        }
        number = 33;
        ready = true;
        System.out.println(ready);
        System.out.println("mainThread " + Thread.currentThread().getName() + " over");
    }

    static class ShareThread implements Runnable {

        @Override
        public void run() {
            while (!ready) {
                System.out.println(Thread.currentThread().getName() + ": " + System.currentTimeMillis());
            }
            System.out.println(Thread.currentThread().getName() + ": " + number);
        }
    }
}
