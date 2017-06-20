package precipitated.will.basicType.constant;

/**
 * http://www.ibm.com/developerworks/cn/java/l-java-interface/index.html
 * Created by will.wang on 2017/2/7.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("interface: " + IA.CONSTANT);
        System.out.println("class.a: " + ClassA.CONSTANT_A);
        System.out.println("class.b: " + ClassA.getConstantB());
    }
}
