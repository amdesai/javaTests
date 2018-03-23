package algoProblemSolutions.backtracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class WordSearch {

    public static void main(String[] args) {
        char[][] input = {  {'a'}};
        System.out.println(new WordSearch().exist(input, "a"));
    }

    public static Map<String, Boolean> seen = new HashMap<String, Boolean>();

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0)
            return false;
        if (word == null || word.length() == 0)
            return false;
        int tR = board.length;
        int tC = board[0].length;
        for (int r = 0; r < tR; r++) {
            for (int c = 0; c < tC; c++) {
                if (board[r][c] == word.charAt(0) && findWordByDFS(board, r, tR, c, tC, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean findWordByDFS(char[][] b, int r, int tR, int c, int tC, String w, int i) {
        if (i == w.length()) {
            return true;
        }
        char chr = w.charAt(i);
        if (r < 0 || r >= tR || c < 0 || c >= tC || b[r][c] != chr || seen.containsKey(r + " and " + c)) {
            return false;
        }
        seen.put(r + " and " + c, true);
        if (findWordByDFS(b, r - 1, tR, c, tC, w, i + 1)
                || findWordByDFS(b, r + 1, tR, c, tC, w, i + 1)
                || findWordByDFS(b, r, tR, c - 1, tC, w, i + 1)
                || findWordByDFS(b, r, tR, c + 1, tC, w, i + 1)) {
            return true;
        }
        seen.put( r + " and " + c, false);
        return false;
    }
}