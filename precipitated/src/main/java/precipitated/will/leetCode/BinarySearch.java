package precipitated.will.leetCode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by will on 17/6/9.
 */
public class BinarySearch {

    private static Logger logger = LoggerFactory.getLogger(BinarySearch.class);

    public static int binarySearch(int[] A, int start, int end, int t) {
        if(A == null || A.length <= 0) {
            return -1;
        }

        logger.info("fdfdf");

        while (start < end) {
            int mid = (end - start) / 2 + start;
            if(A[mid] == t) {
                return mid;
            }
            if(A[mid] > t) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
//
//        if(A[start] == t) {
//            return start;
//        }
        return -1;
    }


    public static void main(String[] args) {
        int[] A = new int[]{2,3,3,5,6};
        System.out.println(binarySearch(A, 0, A.length-1, 9));
    }
}
