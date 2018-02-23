package randomAnitest.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class JumpGame {


    /*Given an array of non-negative integers, you are initially positioned at the first index of the array.
    Each element in the array represents your maximum jump length at that position.
    Determine if you are able to reach the last index.
    For example:
    A = [2,3,1,1,4], return true.
    A = [3,2,1,0,4], return false.
                                                    j
    int[] input = {3, 1, 2, 4, 1, 1, 2, 5, 1, 0, 1, 2}
                   0  1  2  3  4  5  6  7  8  9  10 11
                                                         i
    j = 0
    i = 5
    minJumps: min(minJumps[i], minJumps[j] + 1)

    minJumps
    0,   1,     1,     1,    2,     2,    2,    2,     3,    3,     3,     3
    0    1      2      3     4      5     6     7      8     9     10    11
    */

    public static void main (String ... args) throws Exception {

//        int[] input = {1,0,1,0};
//        System.out.println(new JumpGame().minJumps(input));


        int[] input1 = {2, 3, 4, 0, 4, 0, 1, 3, 1, 8};

        ArrayList<Integer> path = new ArrayList<>();

        System.out.println(new JumpGame().findMinJumps(input1, path));

        System.out.println("path: " + path.toString());

    }

    int minJumps(int[] data) {

        if (data == null || data.length == 0) {
            return -1;
        }
        if (data.length == 1) {
            return 0;
        }
        int[] minJumps = new int[data.length];
        Arrays.fill(minJumps, Integer.MAX_VALUE);
        minJumps[0] = 0;
        for (int i = 1; i < data.length; i++) {
            for (int j = 0; j < i; j++) {
                if (data[j] + j >= i && minJumps[j] < Integer.MAX_VALUE) {
                    minJumps[i] = Math.min(minJumps[i], minJumps[j] + 1);
                }
            }
        }
        return minJumps[data.length-1];
    }



    /*O(n) solution with O(1) space
    .       .                .
    2, 3, 4, 6, 6, 6, 7, 7, 7, 8
    0  1  2  3  4  5  6  7  8  9
                                         i
    i = 9 // if i == data.length - 1 - we are done:
    maxReach = 2 // max(maxReach, data[i] + i): 17
    reachAdder = 0 // 9
    stepsLeft = 2 // reset as: maxReach - i: 4
    minJumps = 1 // 3
    list: 0, 2, 6, 9
    */
    int findMinJumps(int[] data, ArrayList<Integer> path) throws Exception {
        if (data == null || data.length == 0) throw new Exception();
        if (data[0] == 0) return -1;
        int minJumps = 1;
        int i = 1;
        int maxReachable = data[0];
        int reachAdder = 0;
        int stepsRemaining = data[0];
        path.add(0); // add start index
        while (i < data.length) {
            if (i == data.length-1) {// reached the end!
                path.add(i);
                return minJumps;
            }
            if (maxReachable < data[i] + i) {
                maxReachable = data[i] + i;
                reachAdder = i;
            }
            stepsRemaining--;
            if (stepsRemaining == 0) {
                minJumps++;
                path.add(reachAdder); // the last element that helped “go further”
                if (maxReachable <= i) { // cannot go any further
                    return -1;
                } else {
                    stepsRemaining = maxReachable - i; // at least one step left
                }
            }
            i++; // increment i
        }

        return -1; // we should never get to this point
    }

}
