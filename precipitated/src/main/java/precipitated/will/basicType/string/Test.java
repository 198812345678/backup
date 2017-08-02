package precipitated.will.basicType.string;

/**
 * Created by will on 17/7/20.
 */
public class Test {


    public static void main(String[] args) {
        Test.test6();
    }

    private static void test1() {
        String a = "a1";
        String b = "a" + 1;
        System.out.println(a == b);
    }

    private static void test2() {
        String a = "ab";
        String bb = "b";
        String b = "a" + bb;
        System.out.println(a == b);
    }

    private static void test3() {
        String a = "ab";
        final String bb = "b";
        String b = "a" + bb;
        System.out.println(a == b);
    }

    private static void test4() {

        String a = "ab";
        final String bb = getBB();
        String b = "a" + bb;
        System.out.println(a == b);
    }

    private static String getBB() {
        return "b";
    }

    private static String a = "ab";

    private static void test5() {
        String s1 = "a";
        String s2 = "b";
        String s = s1 + s2;
        System.out.println(s == a);
        System.out.println(s.intern() == a);
    }

    private static String ab = new String("ab");
    private static void test6() {
        String s1 = "a";
        String s2 = "b";
        String s = s1 + s2;
        System.out.println(s == s.intern());
        System.out.println(s.intern() == ab);
        System.out.println(s.intern() == ab.intern());
    }
}
