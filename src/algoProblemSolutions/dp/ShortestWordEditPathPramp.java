package algoProblemSolutions.dp;
import java.io.*;
import java.util.*;
/*
Shortest Word Edit Path
Given two words source and target, and a list of words words, find the length of the shortest series of edits that transforms source to target.

Each edit must change exactly one letter at a time, and each intermediate word (and the final target word) must exist in words.

If the task is impossible, return -1.

Examples:

source = "bit", target = "dog"
words = ["but", "put", "big", "pot", "pog", "dog", "lot"]
output: 5
explanation: bit -> but -> put -> pot -> pog -> dog has 5 transitions.

source = "no", target = "go"
words = ["to"]
output: -1


*/

public class ShortestWordEditPathPramp {

  /*

  Traveloka?

  SAP Concur

  Faris?
  Ani

  words.size - N
  O(N^2)

  source.length = M
  O(M*N)

  O(N)

  TRIE

          Root
         b    d   l    p
       u   i o

bit - dog -
    <but - dog> - sI 0
      put - dog   sI 1
        <pot - dog>: 4 --> 4
        ..
        ..
        pit - dog --> 7


  bit

       bat - bug [bat, [but, [bug --> xyz:abc --3
       but - bug ---> 2 --> xyz:abc

       min (rec1, rec2,...)

  but


  bug

  */

    static int shortestWordEditPath(String source, String target, String[] words) {
        // your code goes here
        Set<String> dict = new HashSet<String>();
        for (String w: words) dict.add(w);
        if (!dict.contains(target)) return -1;
        Map<String, Integer> memo = new HashMap<String, Integer>();
        HashSet<String> seen = new HashSet<String>();
        helper(source, target, dict, memo, seen);
        int ans = memo.get(source+"-"+target);
        return ans == Integer.MAX_VALUE ? -1: ans;
    }

    static void helper(String s, String t, Set<String> dict, Map<String, Integer> memo, HashSet<String> seen) {
        if (dict.contains(t)) {
            if (s.equals(t)) {
                memo.put(s + "-" + t, 0);
            } else {
                // recursive logic
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < s.length(); i++) {
                    for (int j = 0; j < 26; j++) {
                        seen.add(s);
                        char c = (char) ('a' + j);
                        String cd = s;
                        cd = cd.substring(0, i) + c + cd.substring(i + 1);
                        String key = cd + "-" + t;
                        if (!seen.contains(cd) && dict.contains(cd)) {
                            System.out.println("key = " + key);
                            if (!memo.containsKey(key)) {
                                helper(cd, t, dict, memo, seen);
                            }
                            min = Math.min(memo.get(key), min);
                        }
                    }
                }
                memo.put(s + "-" + t, min == Integer.MAX_VALUE? min: 1 + min);
            }
        }
    }



    public static void main(String[] args) {

        String[] wrds = new String[] {"but", "put", "big", "pot", "pog", "dog", "lot"};
        System.out.println(shortestWordEditPath("pot", "dog", wrds));

    }


}

