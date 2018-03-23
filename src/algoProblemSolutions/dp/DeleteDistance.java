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

    static int deletionDistance(String str1, String str2) {
        int[][] memo = new int[str1.length()+1][str2.length()+1];
        // your code goes here
        deletionDistance(str1, str2, str1.length(), str2.length(), memo);
        return memo[str1.length()][str2.length()];
    }

    //str1 - heat
    //str1 - hit

    static void deletionDistance(String str1, String str2, int i, int j, int[][] memo) {
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
                    deletionDistance(str1, str2, i-1, j-1, memo);
                memo[i][j] = memo[i-1][j-1];
                System.out.println(memo[i][j]);
            } else {
                if (memo[i-1][j] == 0)
                    deletionDistance(str1, str2, i-1, j, memo);
                if (memo[i][j-1] == 0)
                    deletionDistance(str1, str2, i, j-1, memo);
                if (memo[i-1][j-1] == 0)
                    deletionDistance(str1, str2, i-1, j-1, memo);
                memo[i][j] = Math.min(Math.min(memo[i-1][j] + 1, memo[i][j-1] + 1), memo[i-1][j-1] + 2);
                System.out.println(memo[i][j]);
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(deletionDistance("hot", "not"));
        System.out.println(deletionDistance("hot", "not"));

    }



}
