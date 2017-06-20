package precipitated.will.leetCode;

import java.util.*;

/**
 * Created by will on 17/6/1.
 */
public class p15 {

    public static void main(String[] args) {
        threeSum(new int[]{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0});
        List list = new ArrayList<>();

        Set<String> set = new HashSet<String>();


    }

        public static List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new LinkedList<List<Integer>>();
            if(nums == null || nums.length < 3) {
                return result;
            }

            Arrays.sort(nums);


            for(int i = 0; i < nums.length-2; ++i) {

                int base = nums[i];
                int target = 0 - base;

                List<List<Integer>> tem = twoSum(Arrays.copyOfRange(nums, i+1, nums.length), target);

                if(tem == null || tem.size() == 0) {
                    continue;
                }

                for(List<Integer> item : tem) {
                    item.add(base);

                    result.add(item);
                }


            }

            //去重
            result = duplicatedFilter(result);
            return result;
        }

        private static List<List<Integer>> duplicatedFilter(List<List<Integer>> list) {
            List<List<Integer>> result = new LinkedList<List<Integer>>();
            if(list == null || list.size() == 0) {
                return list;
            }

            for(List<Integer> item : list) {
                boolean isDuplicated = false;
                int i1 = item.get(0);
                int i2 = item.get(1);
                if(!contain(result, i1, i2)) {
                    result.add(item);
                }
            }
            return result;
        }

        private static boolean contain(List<List<Integer>> list, int i1, int i2) {
            if(list == null || list.size() == 0) {
                return false;
            }

            for(List<Integer> item : list) {
                if(item.contains(i1) && item.contains(i2)) {
                    return true;
                }
            }
            return false;
        }

        private static List<List<Integer>> twoSum(final int[] nums, int target) {
            if(nums == null || nums.length < 2) {
                return null;
            }

            List<List<Integer>> result = new LinkedList<List<Integer>>();
            int one = 0;
            int two = nums.length-1;

            while(one < two && one < nums.length && two >= 0) {
                while(one < two && one < nums.length && two >= 0) {
                    if(nums[one] + nums[two] == target) {
                        break;
                    }

                    if(nums[one] + nums[two] < target) {
                        ++one;
                        continue;
                    }

                    --two;
                }

                if(one < two && nums[one] + nums[two] == target) {
                    List list = new ArrayList<Integer>();
                    list.add(nums[one]);
                    list.add(nums[two]);
                    result.add(list);
                }

                one++;
                two--;
            }


            return result;
        }
}
