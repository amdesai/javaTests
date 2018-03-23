package algoProblemSolutions.arrays;

public class HouseRobber {
/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

input = {4, 12, 6, 1, 8, 2, 0, 11, 3, 9}
             0   1   2  3  4  5  6   7   8  9
                                                     #
i = 10 done
curr = 9
prevMaxWcurr (hold the previous val of maxWcurr) = 23
maxWcurr = (maxWOcurr + curr)) = 40
maxWOcurr = max(prevMaxWcurr, maxWOcurr) = 31
*/

    public static void main(String ... args) {

        int[] input = {13, 2, 6, 1, 12, 3, 25, 23, 5, 9};

        System.out.println(new HouseRobber().maxAmountMoney(input));

    }

    int maxAmountMoney(int[] data) {

        // input validation
        if (data == null || data.length == 0) {
            return 0;
        }

        int maxWcurr = 0;
        int maxWOcurr = 0;

        for (int i = 0; i < data.length; i++) {
            int prevMaxWcurr = maxWcurr;
            maxWcurr = maxWOcurr + data[i];
            maxWOcurr = Math.max(prevMaxWcurr, maxWOcurr);
        }

        return Math.max(maxWcurr, maxWOcurr);
    }
}