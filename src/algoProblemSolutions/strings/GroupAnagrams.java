package algoProblemSolutions.strings;

import java.util.*;


public class GroupAnagrams {
/*
Given an array of strings, group anagrams together.
For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
Return:
[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
*/

    public static void main(String[] args) {

        Queue<Integer> q = new ArrayDeque<>();

        String[] data = {"eaten", "tea", "eanet", "ate", "stabs", "nat", "basts"};
        System.out.println(new GroupAnagrams().groupAnagrams(data).toString());

    }

    List<List<String>> groupAnagrams(String[] ar) {

        List<List<String>> ans = new ArrayList<>();

        Map<String, List<String>> seen = new HashMap<>();

        for (String s : ar) {
            String hashKey = hash(s);
            List l;
            if (seen.containsKey(hashKey)) {
                l = seen.get(hashKey);
            } else {
                l = new ArrayList<String>();
                seen.put(hashKey, l);
            }
            l.add(s);
        }

        for (List li : seen.values()) {
            ans.add(li);
        }
        return ans;
    }

    String hash (String s) {
        int[] counts = new int[26];
        char[] chs = s.toCharArray ();
        for (char c : chs)
            counts[c - 'a']++;
        StringBuilder sb = new StringBuilder ();
        for (int count : counts)
            sb.append (count + "");
        return sb.toString ();
    }

}