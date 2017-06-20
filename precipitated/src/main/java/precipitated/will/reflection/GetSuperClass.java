package precipitated.will.reflection;

/**
 * Created by will.wang on 2015/12/30.
 */
public class GetSuperClass {

    public static void main(String[] args) {
        Class concreteClass = ConcreteClass.class;
        Class superClass = concreteClass.getSuperclass();
        System.out.println(superClass);
    }
}
