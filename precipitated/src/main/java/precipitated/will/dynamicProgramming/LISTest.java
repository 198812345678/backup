package precipitated.will.dynamicProgramming;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LIS：longest increasing subsequence讲解动态规划，但是和博客结果又出入，应该是博客代码不对
 * http://www.hawstein.com/posts/dp-novice-to-advanced.html
 * Created by will.wang on 2015/5/4.
 */
public class LISTest {

    public static int lis(List<Integer> A, int n) {
        Integer[] tmp = new Integer[n];
        List<Integer> d = Arrays.asList(tmp);
        int len = 1;
        for (int i = 0; i < n; i++) {
            d.set(i, 1);
            for (int j = 0; j < i; j++) {
                if((A.get(j) < A.get(i)) && (d.get(j) + 1 > d.get(i)) && (i-j==1)) {
                    d.set(i, d.get(j) + 1);
                }

                if(d.get(i) > len) {
                    len = d.get(i);
                }
            }
        }

        return len;
//        return d.get(A.size() - 1);
    }

    public static void main(String[] args) {
        List<Integer> A = Lists.newArrayList(5, 3, 4, 8, 6, 7);
        int result = LISTest.lis(A, A.size());
        System.out.println(result);
    }
}
