package randomAnitest.arrays;

import java.util.Arrays;

public class MultiplyStrings {

    /*
    Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
    Note:
    The length of both num1 and num2 is < 110.
    Both num1 and num2 contains only digits 0-9.
    Both num1 and num2 does not contain any leading zero.
    You must not use any built-in BigInteger library or convert the inputs to integer directly.
    3,4,0,8
        i
    2,9,1,5,6
           j
    carry - 2
    i = 2
             0  1  2  3  4  5  6  7  8
    int[] - 8, 4, 6, 5, 9, 2
    */

    public static void main(String ... args) {
        System.out.println(new MultiplyStrings().multiply(  "00023567889879782879788709855654345570978344530178946779",
                                                            "0000293472387687567567445054634564364563456234528972340"));
    }

    public String multiply(String num1, String num2) {
        int[] prod = new int[num1.length() + num2.length()];
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        Arrays.fill(prod, 0);
        for (int i = n1.length-1; i >= 0; i--) {
            int carry = 0;
            int k = prod.length - 1 - (n1.length - 1 - i);
            int d1 = n1[i] - '0';
            for (int j = n2.length-1; j >= 0; j--) {
                int d2 = n2[j] - '0';
                int pr = d1 * d2;
                prod[k] += pr + carry;
                carry = prod[k] / 10;
                prod[k] = prod[k] % 10;
                k--;
            }
            prod[k] = carry;
        }
        // convert the array into a string
        StringBuilder result = new StringBuilder();
        int i = 0;
        boolean foundNonZero = false;
        while (i < prod.length) {
            if (prod[i] != 0) {
                foundNonZero = true;
                result.append(prod[i]);
            } else if (foundNonZero) {
                result.append(prod[i]);
            }
            i++;
        }
        if (result.toString().equals("")) {
            return "0";
        }
        return result.toString();
    }


}
