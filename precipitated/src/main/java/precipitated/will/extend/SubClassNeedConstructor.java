package precipitated.will.extend;

import precipitated.will.serialize.SuperClass;

/**
 * Created by will.wang on 2016/4/13.
 */
public class SubClassNeedConstructor extends SuperClass {

    /**
     * 父类没有默认构造方法，子类必须要实现有参构造方法
     */
    public SubClassNeedConstructor(int i) {
        super(i);
    }

    public static void main(String[] args) {
        System.out.println(new SubClassNeedConstructor(1));
    }
}
