package precipitated.will.reflection;

import java.util.Arrays;

/**
 * Created by will.wang on 2015/12/30.
 */
public class GetDeclaredClasses {

    public static void main(String[] args) {
        Class[] classes = ConcreteClass.class.getDeclaredClasses();
        System.out.println(Arrays.toString(classes));
    }
}
