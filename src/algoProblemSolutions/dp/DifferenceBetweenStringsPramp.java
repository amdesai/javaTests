package algoProblemSolutions.dp;

/*
Given two strings of uppercase letters source and target, list (in string form) a sequence of edits to convert from source to target that uses the least edits possible.

For example, with strings source = "ABCDEFG", and target = "ABDFFGH" we might return: ["A", "B", "-C", "D", "-E", "F", "+F", "G", "+H"

More formally, for each character C in source, we will either write the token C, which does not count as an edit; or write the token -C, which counts as an edit.

Additionally, between any token that we write, we may write +D where D is any letter, which counts as an edit.

At the end, when reading the tokens from left to right, and not including tokens prefixed with a minus-sign, the letters should spell out target (when ignoring plus-signs.)

In the example, the answer of A B -C D -E F +F G +H has total number of edits 4 (the minimum possible), and ignoring subtraction-tokens, spells out A, B, D, F, +F, G, +H which represents the string target.

If there are multiple answers, use the answer that favors removing from the source first.

*/
public class DifferenceBetweenStringsPramp {

/*

source = "ABCDEFG", and target = "ABDFFGH" we might return: ["A", "B", "-C", "D", "-E", "F", "+F", "G", "+H"]

s   A   B   D   E   FG
t   A   B   D   F   FGH

    ans = A, B,
            A, B, -C
            A, B, -C, D
                    A, B, -C, D, -E
                    A, B, -C, D, +F
            A, B, +D
                    A, B, +D, -C
                    A, B, +D, +F


*/

    static String differenceBetweenStrings(String s, String t) {
        String ans = "";
        int sL = s.length();
        int tL = t.length();
        ans = diffHelper(s, t, 0, 0, sL, tL, ans);
        return ans.substring(0, ans.length()-2);
    }

    private static String diffHelper(String s, String t, int sI, int tI, int sL, int tL, String ans) {
        if (sI == sL && tI == tL) return "";
        if (sI == sL) return ans + remainingChars("+", t, tI);
        if (tI == tL) return ans + remainingChars("-", s, sI);
        if (s.charAt(sI) == t.charAt(tI)) {
            ans += s.charAt(sI) + ", " + diffHelper(s, t, sI+1, tI+1, sL, tL, ans);
        } else {
            String ansRem = diffHelper(s, t, sI+1, tI, sL, tL, ans);
            String ansAdd = diffHelper(s, t, sI, tI+1, sL, tL, ans);
            ans += ansRem.length() <= ansAdd.length() ? ("-" +  s.charAt(sI) + ", " + ansRem) : ("+" +  t.charAt(tI) + ", " + ansAdd);
        }
        return ans;
    }

    static String differenceBetweenStringsMemo(String s, String t) {
        String ans = "";
        int sL = s.length();
        int tL = t.length();
        String[][] memo = new String[sL+1][tL+1];
        diffHelperMemo(s, t, 0, 0, sL, tL, memo);
        return memo[0][0];
    }

    private static void diffHelperMemo(String s, String t, int sI, int tI, int sL, int tL, String[][] memo) {
        if (sI == sL || tI == tL) {
            if (sI == sL && tI == tL) memo[sI][tI] = "";
            if (sI == sL) memo[sI][tI] = remainingChars("+", t, tI);
            if (tI == tL) memo[sI][tI] = remainingChars("-", s, sI);
            return;
        }
        String res = "";
        if (s.charAt(sI) == t.charAt(tI)) {
            if (memo[sI+1][tI+1] == null) {
                diffHelperMemo(s, t, sI+1, tI+1, sL, tL, memo);
            }
            res += s.charAt(sI) + ", " + memo[sI+1][tI+1];
        } else {
            if (memo[sI+1][tI] == null)
                diffHelperMemo(s, t, sI+1, tI, sL, tL, memo);
            if (memo[sI][tI+1] == null)
                diffHelperMemo(s, t, sI, tI+1, sL, tL, memo);
            res += memo[sI+1][tI].length() <= memo[sI][tI+1].length() ? ("-" +  s.charAt(sI) + ", " + memo[sI+1][tI]) : ("+" +  t.charAt(tI) + ", " + memo[sI][tI+1]);
        }
        memo[sI][tI] = res;
    }

    private static String remainingChars(String sep, String t, int tI) {
        String rem = "";
        for (int i = tI; i < t.length(); i++) {
            rem += sep + t.charAt(i) + ", ";
        }
        return rem;
    }


    static void differenceBetweenStrings(String str1, String str2, int i, int j, int[][] memo) {
    }

    public static void main(String[] args) {

        System.out.println(differenceBetweenStrings("ABCDEFG", "ABDFFGH"));

        long s, e;
        s = System.currentTimeMillis();
        System.out.println(differenceBetweenStrings("ABCDEFGHKMOPRTSXYZ", "AADDFFGGHLMSXYYZZ"));
        e = System.currentTimeMillis();
        System.out.println("time taken: " + (e - s) + " ms.");
        s = System.currentTimeMillis();
        System.out.println(differenceBetweenStringsMemo("ABCDEFGHKMOPRTSXYZ", "AADDFFGGHLMSXYYZZ"));
        e = System.currentTimeMillis();
        System.out.println("time taken: " + (e - s) + " ms.");
        s = System.currentTimeMillis();
        System.out.println(differenceBetweenStringsMemo("ABCCCDEFGGHIIJJKKLMOOOPQRRTTTTSXYZ", "AADDFFGGHIIJJJJLLLLMPPRRRSTRXYYZZZZ"));
        e = System.currentTimeMillis();
        System.out.println("time taken: " + (e - s) + " ms.");

    }



}
