package problem.one;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        int[] numbers = new int[]{7, 3, 2, 15};
        int target = 9;

        Main2 main = new Main2();
        System.out.println(main.twoSum(numbers, target));
    }

    private static int[] twoSum(int[] numbers, int target) {

        int[] numbersBackup = numbers;

        Map<Integer, Integer> indexMap = new HashMap();

        for (int i = 0; i < numbers.length; i++) {
            indexMap.put(numbers[i], i);
        }

        Arrays.sort(numbersBackup);

        int firstIndex = 0;
        int secondIndex = numbersBackup.length - 1;

        int[] result = new int[2];
        while (firstIndex < secondIndex) {
            int sum = numbersBackup[firstIndex] + numbersBackup[secondIndex];
            if(sum == target) {
                int fIndex = indexMap.get(numbersBackup[firstIndex]) + 1;
                int sIndex = indexMap.get(numbersBackup[secondIndex]) + 1;

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
