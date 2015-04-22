package problem.one;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] numbers = new int[]{7, 3, 2, 7};
        int target = 14;

        Main main = new Main();
        System.out.println(main.twoSum(numbers, target));
    }

    private static int[] twoSum(int[] numbers, int target) {

        int[] numbersBackup = Arrays.copyOf(numbers, numbers.length);

        Map<Integer, Stack<Integer>> indexMap = new HashMap();

        for (int i = 0; i < numbers.length; i++) {
            if(!indexMap.containsKey(numbers[i])) {
                Stack<Integer> indexList = new Stack<Integer>();
                indexList.push(i);
                indexMap.put(numbers[i], indexList);
            } else {
                Stack<Integer> indexList = indexMap.get(numbers[i]);
                indexList.push(i);
            }
        }

        Arrays.sort(numbersBackup);

        int firstIndex = 0;
        int secondIndex = numbersBackup.length - 1;

        int[] result = new int[2];
        while (firstIndex < secondIndex) {
            int sum = numbersBackup[firstIndex] + numbersBackup[secondIndex];
            if(sum == target) {
                int fIndex = indexMap.get(numbersBackup[firstIndex]).pop() + 1;
                int sIndex = indexMap.get(numbersBackup[secondIndex]).pop() + 1;

                result[0] = fIndex > sIndex ? sIndex : fIndex;
                result[1] = fIndex > sIndex ? fIndex : sIndex;

                return result;
            } else if(sum > target) {
                --secondIndex;
            } else {
                ++firstIndex;
            }
        }

        return result;
    }
}
