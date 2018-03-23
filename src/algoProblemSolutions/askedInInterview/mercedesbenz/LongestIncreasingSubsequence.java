package algoProblemSolutions.askedInInterview.mercedesbenz;

import java.util.Arrays;
/*

{24, 17, 7, 1, 6, 9, 3, 35, 99} -> {24, 35, 99} {17, 35, 99} {6, 9, 35, 99} {1, 6, 9, 35, 99}
=> return {1, 6, 9, 35, 99}

*/

public class LongestIncreasingSubsequence {

    private static int[] longestIncreasingSubsequence(int[] input) {
        return new int[0];
    }

    public static void main(String[] args) {
        int[] input = {24, 17, 7, 1, 6, 9, 3, 35, 99};
        System.out.println(Arrays.toString(longestIncreasingSubsequence(input)));
    }

}
