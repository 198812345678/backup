package precipitated.will.basicType.string;

import java.lang.reflect.Field;

/**
 * Java的String对象不可修改？
 * http://www.importnew.com/19971.html
 * Created by will.wang on 2016/6/23.
 */
public class StringModifier {

    public static void main(String[] args) {
        try {
            String test="aaaa";
            String test2 =test;
            String test3 = new String(test);
            String test4 = new String(test.toCharArray());
            Field values = String.class.getDeclaredField("value");

            values.setAccessible(true);
            char[] ref = (char [])values.get(test);
            ref[0] = 'b';

            System.out.println("aaaa"+test+" "+test2+" "+test3+" "+test4);
        } catch (NoSuchFieldException|SecurityException|
                IllegalArgumentException|IllegalAccessException ex) {
        }
    }
}
