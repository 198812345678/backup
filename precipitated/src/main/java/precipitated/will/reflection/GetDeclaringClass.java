package precipitated.will.reflection;

/**
 * 声明内部类的外部类
 * Created by will.wang on 2015/12/30.
 */
public class GetDeclaringClass {

    public static void main(String[] args) {
        Class innerClass = ConcreteClass.ConcreteClassProtectedClass.class;
        System.out.println(innerClass);
        System.out.println(innerClass.getCanonicalName());
        System.out.println(innerClass.getDeclaringClass());
        System.out.println(innerClass.getEnclosingClass());
    }
}
