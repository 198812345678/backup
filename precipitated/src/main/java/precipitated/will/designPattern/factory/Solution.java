package precipitated.will.designPattern.factory;

/**
 * Created by will.wang on 2016/1/13.
 */
public class Solution {


    public static void main(String[] args) {


        Boolean bTrue =  Boolean.valueOf(true);
        bTrue = false;
        System.out.println(bTrue);

        final Boolean fBTrue = new Boolean(true);
        bTrue = fBTrue;
        bTrue = false;
        System.out.println(fBTrue);
    }
}
