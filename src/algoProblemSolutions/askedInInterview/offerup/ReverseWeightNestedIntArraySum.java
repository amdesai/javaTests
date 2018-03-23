package algoProblemSolutions.askedInInterview.offerup;

import java.util.ArrayList;
import java.util.List;

public class ReverseWeightNestedIntArraySum {

/*
{7, {4}, {{1}}, 3} => 7*3 + 4*2 + 1*1 + 3*3 = 39

*/

    public static void main(String[] args) {

        List<Object> test = new ArrayList<Object>();
        test.add(new Integer(7));
        List<Object> in1 = new ArrayList<Object>();
        in1.add(new Integer(4));
        test.add(in1);
        List<Object> in2 = new ArrayList<Object>();
        in2.add(new Integer(1));
        List<Object> in3 = new ArrayList<Object>();
        in3.add(in2);
        test.add(in3);
        test.add(new Integer(3));

        int[] sum = findSum(test);
        System.out.println(sum[0]);

    }

    public static int[] findSum(List<Object> list) {

        int maxDepth = 1;
        List<Integer> flatvals = new ArrayList<Integer>();
        List<Integer> flatdeps = new ArrayList<Integer>();
        for (Object e : list) {
            if (e instanceof Integer) {
                flatvals.add((Integer) e);
                flatdeps.add(1);
            } else {
                int[] inner = findSum((List<Object>)e);
                maxDepth = Math.max(maxDepth, inner[1]);
                flatvals.add(inner[0]);
                flatdeps.add(inner[1]);
            }
        }
        int sum = 0;
        for (int i = 0; i < flatvals.size(); i++) {
            sum += flatvals.get(i) * (maxDepth - flatdeps.get(i) + 1);
        }
        int[] new_ans = new int[2];
        new_ans[0] = sum;
        new_ans[1] = maxDepth + 1;
        return new_ans;
    }

}