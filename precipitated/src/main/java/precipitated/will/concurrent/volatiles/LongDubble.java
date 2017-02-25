package precipitated.will.concurrent.volatiles;

import java.util.Random;

/**
 * Created by will.wang on 2015/12/20.
 */
public class LongDubble extends Thread {

    private static long val;

    private long setVal;

    public LongDubble(long setVal) {
        this.setVal = setVal;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            val = setVal;
            System.out.println(Thread.currentThread().getName() + ": " + Long.toBinaryString(val));
        }
    }

    public static void printBinary(String v) {
        byte[] bytes = v.getBytes();
        for (byte aByte : bytes) {
            System.out.print(Long.toBinaryString(aByte));
        }
    }

    public static void main(String[] args) {
        try {
//            LongDubble thread_1 = new LongDubble(0);
//            LongDubble thread_2 = new LongDubble(-1);
//
//            thread_2.start();
//            thread_1.start();

//            Thread.sleep(500);
            for (int i = 0; i < 100; i++) {
                Random random = new Random();
                int r = random.nextInt(2);
                int l = 0;
                if(r == 1) l = -1;
                LongDubble thread = new LongDubble(l);
                thread.start();
            }
//
//            thread_1.interrupt();
//            thread_2.interrupt();
//            System.out.println(Long.toBinaryString(val));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
