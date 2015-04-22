package precipitated.will;

/**
 * 1.类成员变量默认初始化值
 * Created by will.wang on 2015/4/18.
 */
public class StringTest {

    private int i;
    private String str;

    public StringTest() {
    }

    StringTest(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "Test{" +
                "i=" + i +
                ", str='" + str + '\'' +
                '}';
    }

    public static void main(String[] args) {
        StringTest test = new StringTest();
        System.out.println(test);
        if(test.getStr() == null) {
            System.out.println("String == null");
        }
    }
}
