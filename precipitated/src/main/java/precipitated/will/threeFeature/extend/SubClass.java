package precipitated.will.threeFeature.extend;

/**
 * 父类没有默认构造方法
 * 子类也不允许有默认构造方法，因为子类的默认构造方法会调用父类的默认构造方法
 * Created by will.wang on 2016/6/28.
 */
public class SubClass extends SuperClass {
    private int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public SubClass(int i) {
        super(i);
    }

//    public SuperClass() {
//
//    }
}
