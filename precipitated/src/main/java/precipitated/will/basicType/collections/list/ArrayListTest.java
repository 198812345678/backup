package precipitated.will.basicType.collections.list;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;

/**
 * Created by will on 17/6/21.
 *
 * ArrayList.toArray是浅拷贝
 */
public class ArrayListTest {

    public static void main(String[] args) {
//        ArrayList arrayList = new ArrayList<A>();
//        arrayList.add(new A());
//
//        Object[] arr = arrayList.toArray();
//        ((A)arr[0]).a = 1;
//
//        System.out.println(JSON.toJSONString(arrayList));
//
//
//        A[] t = new A[10];
//        arrayList.toArray(t);
//        t[0].a=2;
//        System.out.println(JSON.toJSONString(arrayList));


//        A[] a = new A[]{new A()};
//        A[] b = new A[1];
//        System.arraycopy(a, 0, b, 0, 1);
//        b[0].a = 299;
//        System.out.println(JSON.toJSONString(a));
//        System.out.println(JSON.toJSONString(b));



        ArrayList<Integer> a = new ArrayList<Integer>(3);
        a.add(0);
        a.add(1);
        a.add(2);

        ArrayList<Integer> b = new ArrayList<Integer>(3);
        b.add(0);
        b.add(1);
        b.add(2);

        a.addAll(1, b);
    }


    static class A{
        public Integer a = 0;
    }
}
