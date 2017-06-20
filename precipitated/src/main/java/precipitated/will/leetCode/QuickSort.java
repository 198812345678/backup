package precipitated.will.leetCode;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * Created by will on 17/6/10.
 */
public class QuickSort {

    public static void quickSort(int[] a, int beg, int end) {
        if(a == null || a.length < 2 || beg >= end) {
            return;
        }

        int b = beg;
        int e = end;

        int flag = a[beg];
        while (beg < end) {
            while (beg < end && a[end] >= flag) {
                --end;
            }

            if(beg < end) {
                a[beg++] = a[end];
            }

            while (beg < end && a[beg] < flag) {
                ++beg;
            }

            if(beg < end) {
                a[end--] = a[beg];
            }

        }

        a[beg] = flag;
        quickSort(a, b, beg-1);
        quickSort(a, beg+1, e);
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,1,3,7,3,1,0};
        quickSort(a, 0, a.length-1);
        System.out.println(JSON.toJSONString(a));
    }
}
