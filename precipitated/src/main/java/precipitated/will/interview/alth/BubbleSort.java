package precipitated.will.interview.alth;

import com.alibaba.fastjson.JSON;

/**
 * Created by will on 17/4/10.
 */
public class BubbleSort {

    public static int[] doSort(int[] arr) {
        if(arr == null || arr.length <= 1) {
            return arr;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = arr.length - 1; j > i ; j--) {
                if(arr[j] < arr[j-1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 6, 0, 2, 10, 30};
        int[] result = BubbleSort.doSort(arr);
        System.out.println(JSON.toJSONString(arr));
    }
}
