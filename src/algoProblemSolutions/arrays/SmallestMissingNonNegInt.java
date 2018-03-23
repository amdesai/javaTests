package algoProblemSolutions.arrays;

import java.util.Arrays;

public class SmallestMissingNonNegInt {
/*

find the smallest non-negative int that is not in the given array

input = {5, 4, 1, 2, 0}
             0  1  2  3  4

missingSet {3, 4}

0  1  2  3  4
5, 6, 1, 2, 0

*/

    public static void main (String ... args) throws Exception {

        int[] input = {1, 4, 7, 12, 10, 7, 3, 8, 6, 8, 2, 5, 6, 0};

        System.out.println(smallestMissingNNInt(input));

    }


    public static int smallestMissingNNInt(int[] data) throws Exception {
        // input validation
        if (data == null || data.length == 0) {
            throw new Exception("Invalid data");
        }

        // we only need to check for the first n-1 elements
        boolean[] set = new boolean[data.length];

        // for all ints in the array that are in the "range" - set to true
        for (int num: data) {
            if (num < data.length) {
                set[num] = true;
            }
        }

        System.out.println(Arrays.toString(set));

        for (int i = 0; i < set.length; i++) {
            if (!set[i]) {
                return i;
            }
        }
        return data.length;
    }

}