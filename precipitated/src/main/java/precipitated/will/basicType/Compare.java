package precipitated.will.basicType;

/**
 * 看看Integer 的源代码就知道了，其实就是Integer 把-127-128 之间的每个值都建立了一个对应的Integer 对象，类似一个缓存。由于Integer 是不可变类，因此这些缓存的Integer 对象可以安全的重复使用。
 * Integer i = XXX ，就是Integer i = Interger.valueOf(XXX), 首先判断XXX 是否在-127-127 之间，如果是直接return 已经存在的对象，否则就只能new 一个了。
 * Created by will.wang on 2016/1/11.
 */
public class Compare {

    public static void main(String[] args) {
        Integer i222 = Integer.valueOf(128);
        Integer i2222 = Integer.valueOf(128);

        System.out.println(i222.equals(i2222));
        System.out.println(i222 == i2222);
    }
}
