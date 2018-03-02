package randomAnitest.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {


    /*

    "abbdadadca"
    a - 4
    b - 2
    c - 1
    d - 3

    */


    public static void main(String ... args) {

        System.out.println(new LongestPalindrome().longestPalindrome("abbdadadca"));

    }



    public int longestPalindrome(String s) {
        // input validation
        if (s == null | s.length() == 0) {
            return 0;
        }
        // int[] charCount = new int[1024];
        Map<Character, Integer> counts = new HashMap<Character, Integer>();
        for (char c: s.toCharArray()) {
            // int charCode = c - 'a';
            // charCount[charCode] += 1;
            Integer cnt = counts.get(c);
            Integer count = cnt == null? 0: cnt;
            counts.put(c, count + 1);
        }
        int count = 0; // 6
        int oddChar = 0;
        for (Map.Entry<Character, Integer> e: counts.entrySet()) {  // a-4, b-2, c-1, d-3
            if (e.getValue() % 2 == 0) {
                count += e.getValue();
            } else {
                count += e.getValue();
                if (oddChar == 0)
                    oddChar = 1;
            }
        }
        return count + oddChar;
    }

}
