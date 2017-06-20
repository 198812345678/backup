package precipitated.will.reflection;

/**
 * Created by will.wang on 2015/12/30.
 */
public class GetClassObject {

    public static void main(String[] args) throws ClassNotFoundException {

        //static variable class
        Class concreteClass = ConcreteClass.class;
        System.out.println(concreteClass);

        //getClass()
        concreteClass = new ConcreteClass().getClass();
//        concreteClass = ConcreteClass[].class;
        System.out.println(concreteClass);

        //Class.forName()
        concreteClass = Class.forName("precipitated.will.reflection.ConcreteClass");
        System.out.println(concreteClass);

        //boolean
        Class booleanClass = boolean.class;
        System.out.println(booleanClass);

        //double
        Class doubleClass = Double.TYPE;//Double.class 有区别的
        System.out.println(doubleClass);

        //double[]
        Class doubleArrayClass = double[].class;//打印出来很特别, 数组都特别
        doubleArrayClass = Class.forName("[D");
        System.out.println(doubleArrayClass);
        System.out.println(doubleArrayClass.getCanonicalName());

        //String[][]
        Class twoDStringArrayClass = String[][].class;
        System.out.println(twoDStringArrayClass.getCanonicalName());
    }
}
