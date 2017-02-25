package precipitated.will.concurrent.immutable;

import java.util.Date;

/**
 * http://javarevisited.blogspot.sg/2013/03/how-to-create-immutable-class-object-java-example-tutorial.html
 * Created by will.wang on 2016/1/2.
 */
public class Solution {

    public static void main(String[] args) {
        WithMutableField mutableField = new WithMutableField(new Date(), "fdf", new CommonClass());




        System.out.println("origin mutable field: " + mutableField.getCommonClass().getI());
        System.out.println("before change mutable field: " + mutableField.getCommonClass().hashCode());
//        Date myDate = mutableField.getDate();
//        myDate.setTime(myDate.getTime());

        CommonClass myCommon = mutableField.getCommonClass();
        myCommon.setI(8);
        System.out.println("changed mutable field: " + mutableField.getCommonClass().getI());
        System.out.println("after change mutable field: " + mutableField.getCommonClass().hashCode());


//        System.out.println(mutableField.getDate().hashCode());
//        System.out.println(myDate.hashCode());

        Date cloneDate = mutableField.getDateCopy();
        cloneDate.setTime(cloneDate.getTime() - 100000000);
//        System.out.println(mutableField.getDate());

//        System.out.println(mutableField.getDate().hashCode());
//        System.out.println(cloneDate.hashCode());



        Boolean bTrue =  Boolean.valueOf(true);
        bTrue = false;
//        System.out.println("get final field from factory: " + Boolean.TRUE);

        final Boolean fBTrue = new Boolean(true);
        bTrue = fBTrue;
        bTrue = false;
//        System.out.println("get object from new: " + fBTrue);
    }
}
