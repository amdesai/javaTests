package algoProblemSolutions.askedInInterview.microsoft;

import java.util.Arrays;
import java.util.List;

public class FindMaxPairSum {

    public static void main(String[] args) {

        Integer[] a = {6, 2, 2, 4, 5, 7, 12, 1, 3, 6, 5, 1, 8};

        List<Integer> input = Arrays.asList(a);

        try {
            System.out.println(findMaxPairSum(input));
        } catch (Exception e) {

        }

    }

    private static int findMaxPairSum(List<Integer> list) throws IllegalAccessException {

        if (list == null || list.size() < 2) {
            throw new IllegalAccessException("Invalid input");
        }
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int ind1 = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max1){
                max1 = list.get(i);
                ind1 = i;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max2 && i != ind1){
                max2 = list.get(i);
            }
        }

        return max1 + max2;
    }

}
