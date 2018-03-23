package algoProblemSolutions.arrays;

import java.util.*;

public class SubArraySums {

    public static void main(String[] args) {

        int[] a = {1, 2, -1, 3, 1, 0, 3, -1, 2, 1, 4, 1, 1, 1, 0, 2, 1, -2, 2};

        System.out.println(Arrays.toString(a) + " | k = 3" + " => " + findNumberOfSubarraysBigOhN(a, 3));
        System.out.println(Arrays.toString(a) + " | k = 3" + " => " + findNumberOfSubarraysBigOhNSq(a, 3));
    }

    public static int findNumberOfSubarraysBigOhN(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        Map<Integer, Integer> sums = new HashMap<Integer, Integer>();
        int count = 0;
        int cSum = 0;
        sums.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            cSum += arr[i];
            if (sums.containsKey(cSum - k)) {
                count += sums.get(cSum - k);
            }
            sums.put(cSum, sums.getOrDefault(cSum, 0) + 1);
        }
        return count;
    }


    public static int findNumberOfSubarraysBigOhNSq(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int count = 0;

        for(int s = 0; s < arr.length; s++) {
            int sum = 0;
            for (int e = s; e < arr.length; e++) {
                sum += arr[e];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
