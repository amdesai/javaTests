package algoProblemSolutions.strings;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubstringContainingAllChars {

      /*
                          e
     input = {x,y,y,z,y,z,x,y,z}
              0 1 2 3 4 5 6 7 8
                        s
      count = 2
      ans - "xyyz"
      arrSet = {z, x} size = >=2

      found
      x -> 1
      z -> 1

      needMap
      z -> 1
      x -> 1


       // your code goes here
        String minStr = "";
        List<Character> arrList = new ArrayList<Character>();
              for(char c : arr){
                  arrList.add(c);
              }

              Set<Character> used = new HashSet<Character>();

              for(int i = 0; i<str.length();i++){
                  String currentStr = "";
                  used = new HashSet<Character>();
                  for(int j = i;j<str.length();j++){
                      currentStr+=str.charAt(j);
                      if(arrList.contains(str.charAt(j))){
                          used.add(str.charAt(j));
                      }

                      if(used.size() == arrList.size()){
                          if(minStr.isEmpty()){
                              minStr = currentStr;
                              break;
                          }
                          if(minStr.length()>currentStr.length()){
                              minStr = currentStr;
                          }
                          break;
                      }
                  }
              }

              return minStr;
      */

        public static String getShortestUniqueSubstring(char[] arr, String str) {
            // your code goes here
            // input validation
            int count = 0;
            Map<Character, Integer> need = new HashMap<Character, Integer>(); //{z, x}
            HashMap<Character, Integer> found = new HashMap<>();

            populateNeedCounts(need, arr);

            int s = 0;
            int e = 0; // 5
            String ans = "";
            char[] chars = str.toCharArray(); // found: x-> 1, z -> 2
            while (e < str.length()) { // x,y,y,z,y,z,x,y,z
                char c = chars[e]; // x
                if (need.containsKey(c)) {
                    if (found.containsKey(c)) {
                        found.put(c, found.get(c) + 1);
                    }
                    else {
                        found.put(c, 1);
                    }
                    if (found.get(c) <= need.get(c))
                        count++; // 0
                    if (count >= arr.length) {// a solution is found
                        while (!need.containsKey(chars[s]) || found.get(chars[s]) > need.get(chars[s])) {
                            if (need.containsKey(chars[s]))
                                found.put(chars[s], found.get(chars[s]) - 1);
                            s++;
                        }
                        if (ans.length() == 0 || e - s + 1 < ans.length()) {
                            ans = str.substring(s, e+1);
                        }
                    }
                }
                e++;
            }
            return ans;
        }

    private static void populateNeedCounts(Map<Character, Integer> need, char[] arr) {
        for (char c: arr) {
            Integer integer = need.get(c);
            need.put(c, integer == null? 1: integer +1);

        }
    }

    public static void main(String[] args) {

            char[] ar = {'y', 'b'};
            System.out.println(getShortestUniqueSubstring( ar,"bcccxxxcyyyyaaaabaayzzzzzyycccczb"));

    }


}
