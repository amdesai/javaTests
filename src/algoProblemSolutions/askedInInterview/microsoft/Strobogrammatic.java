


/*

input -
any string - any punctuation will cause false - .,
negative is valid but always returns false
"" - empty returns false

same - 0, 1, 8
comp - 6 (9), 9 (6)

801,108

map
0 -> 0
6 -> 9

69669 - 6 9 9 6 9
  l
  r

*/
package algoProblemSolutions.askedInInterview.microsoft;

import java.util.*;

public class Strobogrammatic {

    public static boolean isStrobogrammatic(String num) {

        // input validation
        if (num == null || num.length() == 0) {
            return false;
        }

        int l = 0;
        int r = num.length() - 1;

        //create map
        Map<Character, Character> map = new HashMap<>();
        map.put('0','0');
        map.put('8','8');
        map.put('1','1');
        map.put('6','9');
        map.put('9','6');

        while (l <= r) { // 60619
            char lC = num.charAt(l); // l : 6
            char rC = num.charAt(r); // r :
            // check for illegal char
            if (!map.containsKey(lC) || !map.containsKey(rC)) {
                return false;
            }
            if (map.get(lC) == rC) { // lC = 6 | rC = 6
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {

        System.out.println("818: " + isStrobogrammatic("818"));
        System.out.println("6969: " + isStrobogrammatic("6969"));
        System.out.println("69669: " + isStrobogrammatic("69669"));
        System.out.println("null input : " + isStrobogrammatic(null));

    }
}
