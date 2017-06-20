package precipitated.will.leetCode;

/**
 * Created by will on 17/6/3.
 */
public class p88 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = new int[]{2,5,6};
        int n = 3;

        merge(nums1, m, nums2, n);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //边界处理
        if(nums1 == null || nums1.length < m + n
                || nums2 == null || nums2.length != n) {
            return;
        }

        //第0个位置作为起始
        int i1 = 0;
        int i2 = 0;

        //两个数组都没有结束，循环执行
        while (i1 < m && i2 < n) {
            //如果nums1值小，则位置向后移动
            if(nums1[i1] <= nums2[i2]) {
                ++i1;
            } else {
                //如果nums2值小，插入nums1当前位置前面
                insert(nums1, m, i1++, nums2[i2++]);
                m++;
            }
        }

        //如果有一方有剩余，全都追加在nums1末尾
        while(i2 < n) {
            append(nums1, i1, nums2, i2, n);
            i2++;
        }
    }

    //在nums1的i1位置之后追加nums2从i2开始到结束的所有值
    private static void append(int[] nums1, int i1, int[] nums2, int i2, int n) {
        for(int i = i2; i < n; i++) {
            nums1[i1++] = nums2[i];
        }
    }

    //在nums1的i位置之前插入val
    private static void insert(int[] nums1, int m, int i, int val) {
        for(int j = m-1; j >= i; --j) {
            nums1[j+1] = nums1[j];
        }

        nums1[i] = val;
    }
}
