package algoProblemSolutions.dp;

public class DeleteDistance {

      /*
        i
        heat
        ^
        j
        hat
        ^
        dist(eat, at)
        >dist(at, )
         dist(eat, t)
           dist(at, t)
         dist(at, at)

      */

    static int deletionDistanceRecursive(String str1, String str2) {
        int[][] memo = new int[str1.length()+1][str2.length()+1];
        // your code goes here
        deletionDistanceRecursiveHlpr(str1, str2, str1.length(), str2.length(), memo);
        return memo[str1.length()][str2.length()];
    }

    static void deletionDistanceRecursiveHlpr(String str1, String str2, int i, int j, int[][] memo) {
        if (i < 0 || j < 0) {
            return;
        }
        if (i == 0) { // i: 4
            memo[i][j] = j;
        } else if (j == 0) { // j: 3
            memo[i][j] = i;
        }
        if (i > 0 && j > 0) {

            if (str1.charAt(i-1) == str2.charAt(j-1)) {
                if (memo[i-1][j-1] == 0)
                    deletionDistanceRecursiveHlpr(str1, str2, i-1, j-1, memo);
                memo[i][j] = memo[i-1][j-1];
            } else {
                if (memo[i-1][j] == 0)
                    deletionDistanceRecursiveHlpr(str1, str2, i-1, j, memo);
                if (memo[i][j-1] == 0)
                    deletionDistanceRecursiveHlpr(str1, str2, i, j-1, memo);
                if (memo[i-1][j-1] == 0)
                    deletionDistanceRecursiveHlpr(str1, str2, i-1, j-1, memo);
                memo[i][j] = Math.min(Math.min(memo[i-1][j] + 1, memo[i][j-1] + 1), memo[i-1][j-1] + 2);
            }
        }
    }

    static int delDistIter(String s1, String s2) {
        int s1L = s1.length();
        int s2L = s2.length();
        int[][] memo = new int[s1L+1][s2L+1];
        for (int ind1 = 0; ind1 <= s1L; ind1++) {
            for (int ind2 = 0; ind2 <= s2L; ind2++) {
                if (ind1 == 0) {
                    memo[ind1][ind2] = ind2;
                } else if (ind2 == 0) {
                    memo[ind1][ind2] = ind1;
                } else if (s1.charAt(ind1-1) == s2.charAt(ind2-1)) {
                    memo[ind1][ind2] = memo[ind1-1][ind2-1];
                } else {
                    memo[ind1][ind2] = Math.min(memo[ind1-1][ind2], memo[ind1][ind2-1]) + 1;
                }
            }
        }
        return memo[s1L][s2L];
    }

    public static void main(String[] args) {

        System.out.println(deletionDistanceRecursive("hit", "hat"));
        System.out.println(deletionDistanceRecursive("hot", "not"));

        System.out.println(delDistIter("hit", "hat"));
        System.out.println(delDistIter("hot", "not"));

    }



}
