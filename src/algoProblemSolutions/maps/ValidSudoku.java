package algoProblemSolutions.maps;

import java.util.*;

public class ValidSudoku {

    public static void main(String[] args) {

        char[][] input = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        System.out.println(new ValidSudoku().isValidSudoku(input));

    }

    public boolean isValidSudoku(char[][] board) {
        Map<String, Set<Character>> rows = new HashMap<>();
        Map<String, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> subgrids = new HashMap<>();
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.') continue;
                // check row
                String row = "" + r;
                if (!validVal(rows, row, ch)) return false;
                // check col
                String col = "" + c;
                if (!validVal(cols, col, ch)) return false;
                // check subgrid
                String key = "" + (r/3) + "-" + (c/3);
                if (!validVal(subgrids, key, ch)) return false;
            }
        }
        return true;
    }

    boolean validVal (Map<String, Set<Character>> map, String key, char c) {
        if (!map.containsKey(key)) {
            Set<Character> seen = new HashSet<>();
            seen.add(c);
            map.put(key, seen);
        } else if (!map.get(key).contains(c)) {
            map.get(key).add(c);
        } else {
            return false;
        }
        return true;
    }


}