package algoProblemSolutions.recursion;

public class SodokuSolver {


    static char[] qualified (char[][] board, int row, int col) {

        return null;
    }

    static boolean sudokuSolve(char[][] board) {
        // get next empty cell

        int n = board.length;

        for (int r = 0; r <n; r++) {
            for (int c = 0; c < n; c++) {
                // here i am looping across entire grid
                // check if the cell is empty
                if (board[r][c] == ' ') {
                    char[] options = qualified(board, r, c);
                    if (options == null) { // no options possible
                        return false;
                    } else { // try each option
                        for (char o: options) {
                            board[r][c] = o;
                            if (sudokuSolve(board)) {
                                return true;
                            }
                        }
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
