package algoProblemSolutions.arrays;

import java.util.Arrays;

public class MoveZeroesToLeft {

/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.

write
input = {2, 0, 3, 0, 1, 0, 3, 6, 0, 3, 12, 5}
         0  1  2   3  4  5  6  7 8  9  10  11
read  ^
output  0, 0, 0, 0, 2, 3, 1, 3, 6, 3, 12, 5

*/

    public static void main (String ... args) {

        int[] a = {0, 0, 2, 0, 3, 0, 5, 0, 6, 8, 12, 0, 0, 0, 0, 0, 18, 0, 0};

        System.out.println(Arrays.toString(a));

        new MoveZeroesToLeft().moveZeroesLeft(a);

        System.out.println(Arrays.toString(a));

    }

    void moveZeroesLeft(int[] data) {

        if (data == null || data.length == 0) {
            return;
        }

        int writer = data.length-1;
        for (int reader = data.length-1; reader >=0; reader--) {
            if (data[reader] != 0) {
                data[writer] = data[reader];
                writer--;
            }
        }

        for (int i = 0; i <= writer; i++) {
            data[i] = 0;
        }
    }
}
