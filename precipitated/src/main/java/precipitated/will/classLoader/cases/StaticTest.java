package precipitated.will.classLoader.cases;

/**
 * {@link http://www.importnew.com/18548.html}
 * {@link http://www.cnblogs.com/sophine/p/3531282.html}
 * 顺序：
 * 1:{}
 * 2:static按顺序
 * 3:staticFunction();
 *
 * a赋值的时机：在new出st对象的时候进行对象构造，先初始化成员变量再执行构造方法
 * Created by will.wang on 2016/3/29.
 */
public class StaticTest {
    public static void main(String[] args)
    {
        staticFunction();
    }
    {
        System.out.println("5");
    }

    static StaticTest st = new StaticTest();

    static
    {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    StaticTest()
    {
        System.out.println("3");
        System.out.println("a="+a+",b="+b);
    }

    public static void staticFunction(){
        System.out.println("4");
    }

    int a=110;
    static int b =112;
}
