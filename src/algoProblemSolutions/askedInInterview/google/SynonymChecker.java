package algoProblemSolutions.askedInInterview.google;

import java.util.HashMap;
import java.util.HashSet;

public class SynonymChecker {

    /*    Please use this Google doc to code during your interview. To free your hands for coding, we recommend that you use a headset or a phone with speaker option.

        Given a list of synonym pairs, write a function to determine if some pairs of queries are synonyms. Two queries are synonyms if you can match them (considering synonyms), word by word in order.
        Example: "movie review" and "film rating", with synonyms ('movie', 'film') and ('review', 'rating') is true

                --- Assumptions:
        Number of tokens must match
        synonym finding logic is needed
        Data structure for existing synonyms is a Map<String, Set>

    --- Code:*/

    public static void main(String ... args) {

        String s1 = "match maker";
        String s2 = "deal setter";

        HashMap<String, HashSet<String>> thes = new HashMap<String, HashSet<String>>();

        HashSet<String> match = new HashSet<>();
        match.add("deal");
        HashSet<String> maker = new HashSet<>();
        maker.add("setter");
        thes.put("match", match);
        thes.put("maker", maker);

        System.out.println(new SynonymChecker().canMatch(s1, s2, thes));

        s1 = "match maker";
        s2 = "meal setter";

        System.out.println(new SynonymChecker().canMatch(s1, s2, thes));

    }

    public boolean canMatch(String s1, String s2, HashMap<String, HashSet<String>> thesaurus) {
        // input validation
        if (s1 == null || s2 == null ) {
            return false;
        }
        if (s1.length() == 0 || s2.length() == 0) {
            return false;
        }
        String[] t1 = s1.split(" ");
        String[] t2 = s2.split(" ");
        if (t1.length != t2.length) {
            return false;
        }
        for (int i = 0; i < t1.length; i++) {
            HashSet<String> syns = thesaurus.get(t1[i]);
            if (!syns.contains(t2[i])) {
                return false;
            }
        }
        return true;
    }





}
