package algoProblemSolutions.graphs;

import java.util.Arrays;

public class FindIslands {
        /*
        start at: 2:16pm

        Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

        Example 1:
        11110
        11010
        11000
        00000
        Answer: 1

        Example 2:
        11000
        11000
        00100
        00011
        Answer: 3

        */

    public static void main (String ... args) throws Exception {

        char[][] input = {{'1','1','1','1','0'},
                          {'1','0','0','1','0'},
                          {'1','1','0','0','1'},
                          {'0','1','1','1','1'}};
        System.out.println(new FindIslands().numIslands(input));

        char[][] input1 = {{'1','1','0','0','0'},
                          {'1','1','0','0','0'},
                          {'0','0','1','0','0'},
                          {'0','0','0','1','1'}};
        System.out.println(new FindIslands().numIslands(input1));

        char[][] input2 = {{'1','0','0','0','1'},
                          {'0','0','0','0','0'},
                          {'1','0','0','0','1'},
                          {'0','1','0','1','0'}};
        System.out.println(new FindIslands().numIslands(input2));


    }

    public int numIslands(char[][] data) throws Exception {

        int count = 0;
        // input validation
        if (data == null || data.length == 0) {
            throw new Exception("Invalid data");
        }
        // validate that data array contains only 0s and 1s as well
        boolean[][] isVisited = new boolean[data.length][data[0].length];
        for (boolean[] a: isVisited) {
            Arrays.fill(a, false);
        }
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[0].length; col++) {
                char element = data[row][col];
                if (!isVisited[row][col]) {
                    if (element == '1') {
                        // new land!
                        count++;
                        dfsAroundElement(row, col, data, isVisited);
                    }
                }
            }
        }

        return count;
    }

    void dfsAroundElement(int row, int col, char[][] data, boolean[][] isVisited) {
        // base case
        if (isVisited[row][col]) {
            return;
        }
        // recursive case
        isVisited[row][col] = true;
        // above
        if (isInBoundRow(row-1, data) && data[row-1][col] == '1') {
            dfsAroundElement(row-1, col, data, isVisited);
        }
        // below
        if (isInBoundRow(row+1, data) && data[row+1][col] == '1') {
            dfsAroundElement(row+1, col, data, isVisited);
        }
        // left
        if (isInBoundCol(col-1, data) && data[row][col-1] == '1') {
            dfsAroundElement(row, col-1, data, isVisited);
        }
        // right
        if (isInBoundCol(col+1, data) && data[row][col+1] == '1') {
            dfsAroundElement(row, col+1, data, isVisited);
        }
    }

    boolean isInBoundRow(int row, char[][] data) {
        if (row >= 0 && row < data.length) {
            return true;
        }
        return false;
    }
    boolean isInBoundCol(int col, char[][] data) {
        if (col >= 0 && col < data[0].length) {
            return true;
        }
        return false;
    }


}