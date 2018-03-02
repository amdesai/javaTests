package randomAnitest.askedInInterview.amazon;


import java.util.*;

public class FindNumberOfOccurences {

    /* Write a function that returns the number of times second string can be formed from the characters in first string.

    s1: "a test string out to"
           ***    *    *   ^^^
    a, t, e, s..

    foundCount
    t -> 3
    s -> 5
    o -> 2

    needCount
    s -> 2
    t -> 1
    o -> 1

    s2: "stores"

    s: foundCount(5) / needCount(2) -> 5 / 2 = 2 - 1 = 1

    */

    public static void main(String ... args) throws Exception {


        System.out.println(Math.pow(9, 2));

//
//        FindNumberOfOccurences finder = new FindNumberOfOccurences();
////        System.out.println(finder.numberOfTimesFound("a test string out to", "stores")); // happy path
////        System.out.println(finder.numberOfTimesFound("a test string out to", "")); // empty check
////        System.out.println(finder.numberOfTimesFound("", "stores")); // empty check
////        System.out.println(finder.numberOfTimesFound("", "")); // both empty
////        System.out.println(finder.numberOfTimesFound(null, "stores")); // one string is null
////        System.out.println(finder.numberOfTimesFound("a test string out to", null)); // one of string null
////        System.out.println(finder.numberOfTimesFound(null, null)); // both null
//        System.out.println(finder.numberOfTimesFound("eee ssssss ttttt oooo rrrrr eee ssssssss", "stores")); // both null

    }

    public int numberOfTimesFound(String s1, String s2) throws Exception {

        // input validation
        if(s1 == null || s1.length() == 0) {
            return 0;
        }
        if (s2 == null || s2.length() == 0) {
            return 0;
//            throw new Exception("Invalid");
        }

        Map<Character, Integer> foundCount = new HashMap<Character, Integer>();
        Map<Character, Integer> needCount = new HashMap<Character, Integer>();

        populateNeedMap(needCount, s2);
        populateFoundMap(foundCount, s1, needCount);

        int minExtras = Integer.MAX_VALUE;

        for (Character c: foundCount.keySet()) {
            int countFound = foundCount.get(c);
            int countNeed = needCount.get(c);
            int extra = countFound / countNeed;
            minExtras = Math.min(minExtras, extra);
        }

        return minExtras;
    }

    private void populateNeedMap(Map<Character, Integer> map, String s) {
        for (Character c: s.toCharArray()) {
            Integer cnt = map.get(c);
            if (cnt == null) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
    }

    private void populateFoundMap(Map<Character, Integer> found, String s, Map<Character, Integer> need) {

        for (Character c: s.toCharArray()) {
            if (need.containsKey(c)) {
                Integer cnt = found.get(c);
                if (cnt == null) {
                    found.put(c, 1);
                } else {
                    found.put(c, found.get(c) + 1);
                }
            }
        }

    }


}
