package precipitated.will.basicType.constant;

/**
 * Created by will.wang on 2017/2/7.
 */
public class ClassA {
    public static final String CONSTANT_A = "class.a";  // to class.a.new
    private static final String CONSTANT_B = "class.b.new";  // to class.b.new

    public static String getConstantB() {
        return CONSTANT_B;
    }
}
