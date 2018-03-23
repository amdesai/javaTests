package algoProblemSolutions.arrays;

public class HouseRobberTake2 {

    /*
    Note: This is an extension of House Robber.

    After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

    Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

    input = {4, 12, 6, 1, 8, 2, 0, 11, 3, 9}
             0   1   2  3  4  5  6   7   8  9

    */

    public static void main(String ... args) {

        int[] input = {13, 2, 6, 1, 12, 3, 25, 23, 5, 9};

        System.out.println(new HouseRobberTake2().maxAmount(input));

    }

    int maxAmount(int[] data) {
        return Math.max(maxAmountWithinRange(data, 0, data.length-2), maxAmountWithinRange(data, 1, data.length-1));
    }
    int maxAmountWithinRange(int[] data, int s, int e) {

        // input validation
        if (data == null || data.length == 0) {
            return 0;
        }

        int i = s;
        int curr = 0;
        int prevMaxWcurr = 0;
        int maxWcurr = 0;
        int maxWOcurr = 0;

        while (i <= e) {
            curr = data[i];
            prevMaxWcurr = maxWcurr;
            maxWcurr = maxWOcurr + curr;
            maxWOcurr = Math.max(prevMaxWcurr, maxWOcurr);
            i++;
        }

        return Math.max(maxWcurr, maxWOcurr);
    }



}
