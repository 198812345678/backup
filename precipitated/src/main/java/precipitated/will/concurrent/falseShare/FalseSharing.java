package precipitated.will.concurrent.falseShare;

/**
 * 伪共享
 * 真正的共享是cpu在修改自己的缓存行时不会有其他cpu频繁修改此缓冲行
 * 发生伪共享时，多个线程（多个cpu执行）虽然持有的对象不同，但是在内存中连续，且大小满足在相同缓存行，那么对应到每个cpu的缓存行时会缓存有其他cpu的对象
 * 这时cpu的缓存行中的对象可能被其他cpu频繁修改，那么缓存行中的数据就频繁失效
 * {@link http://ifeve.com/from-javaeye-false-sharing/}
 * Created by will.wang on 2015/12/21.
 */
public class FalseSharing implements Runnable{
    private static int itemCount = 4;
    private static VolatileLong[] volatileLongs;
    private int volatileLongIdex;

    public FalseSharing(int volatileLongIdex) {
        this.volatileLongIdex = volatileLongIdex;
    }

    @Override
    public void run() {
        long r = 500L * 1000L * 1000L;
        for (int i = 0; i < r; i++) {
            volatileLongs[volatileLongIdex].longs = i;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("start........");

        volatileLongs = new VolatileLong[itemCount];
        for (int i = 0; i < volatileLongs.length; i++) {
            volatileLongs[i] = new VolatileLong();
        }

        long s = System.currentTimeMillis();
        runTest();
        System.out.println("duration = " + String.valueOf(System.currentTimeMillis() - s));
    }

    private static void runTest() throws InterruptedException {
        Thread[] threads = new Thread[4];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new FalseSharing(i));
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }


    static class VolatileLong {
        public long longs;
//        public long l1, l2, l3, l4, l5, l6;
//
//        public void ppp() {
//            long ll = l1 + l2 + l3 + l4 + l5 + l6;
//        }
    }
}
