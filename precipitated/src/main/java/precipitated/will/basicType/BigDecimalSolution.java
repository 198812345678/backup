package precipitated.will.basicType;

import java.math.BigDecimal;

/**
 * http://kingxss.iteye.com/blog/1914944
 * 因为double的精度问题，以double为参数的构造方法会将double损失精度值转化成BigDecimal
 * http://blog.csdn.net/jackiehff/article/details/8582449
 * Created by will.wang on 2016/1/5.
 */
public class BigDecimalSolution {

    public static void main(String[] args) {

        BigDecimal di1 = new BigDecimal("2.15");
        BigDecimal di2 = new BigDecimal("1.10");
        System.out.println(di1.subtract(di2));//正确

        BigDecimal di3 = new BigDecimal(2.5);
        BigDecimal di4 = new BigDecimal(1.1);
        System.out.println(di3.subtract(di4));//精度有问题

        System.out.println(new BigDecimal(1.1));
        System.out.println(new BigDecimal(1.1).subtract(new BigDecimal("1.10000000000000088817841970012523233890533447265624")));

    }
}
