package algoProblemSolutions.askedInInterview.mercedesbenz;

import java.io.*;
import java.util.*;

    /*
     * To execute Java, please define "static void main" on a class
     * named Solution.
     *
     * If you need more classes, simply define them inline.
     */


// {24, 17, 7, 1, 6, 9, 3, 35, 99} -> {24, 35, 99} {17, 35, 99} {6, 9, 35, 99} {1, 6, 9, 35, 99}


    /*

         0  1  2  3   4  5   6   7
        {-2, 1, 5, 7, -3, 5, -20, 17, -5, 22} ->
      i:                 ^
    sum: 0  1  6  13 10  15  0   17   0
    max: 0  1  6  13 13  15  15  17
    si:  0  1  1  1   1   7   7   7

    res:            (1,3)(1,5)(7,7)
    */

public class MaxSumSubArray {

    public static int[] maxSumSubArray(int[] data) {

        int[] res = new int[0];
        if (data == null || data.length == 0) {
            return res;
        }
        int max = findMaxElement(data);
        if (max < 0) {
            res = new int[1];
            res[0] = max;
            return res;
        }

        int sum = 0; //
        max = 0; // 1 / 2 / 4
        int si = 0; // 1 / 5
        int[] range = new int[2]; //(1, 3)
        //   0  1  2  3  4   5  6
        for (int i = 0; i < data.length; i++) { // {-1, 2, 1, 1, -6, 2, 0}
            sum += data[i]; // -1 / 0 / 1 / 4 / -2 / 0 / 2 / 2
            if (sum < 0) {
                sum = 0;
                // update start index for begining new subarray
                si = i + 1;
            } else {
                if (sum > max) {
                    max = sum;
                    range[0] = si;
                    range[1] = i;
                }
            }
        }

        // process the max range to build result array
        int size = range[1] - range[0] + 1;
        res = new int[size];
        int index = 0;
        for (int i = range[0]; i <= range[1]; i++) { // {2, 1,1}
            res[index++] = data[i];
        }

        return res;
    }

    private static int findMaxElement(int[] arr) {

        int max = Integer.MIN_VALUE;

        for (int i: arr) {
            max = Math.max(max, i);
        }

        return max;

    }


    public static void main(String[] args) {

        int[] input = {-1, 0, 4, 5, -22, 1, 11, -6, -2, 10};

        System.out.println(Arrays.toString(maxSumSubArray(input)));


    }
}
