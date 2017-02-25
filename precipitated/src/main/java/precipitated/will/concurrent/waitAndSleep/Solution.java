package precipitated.will.concurrent.waitAndSleep;

/**
 * wait()一定要在获得monitor(synchronized)后才能调用
 * Created by will.wang on 2016/1/2.
 */
public class Solution {

    public static void main(String[] args) throws InterruptedException {
        Object obj = new String();
        obj.wait();
    }
}
