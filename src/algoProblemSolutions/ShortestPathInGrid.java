package algoProblemSolutions;

import java.io.*;
import java.util.*;

public class ShortestPathInGrid {

/*
        1111
        1111
        1011

        curr.y = 2, max_row = 3
        1111
        1001
        1111

*/

    static int shortestCellPath(int[][] grid, int sr, int sc, int tr, int tc) {

        // input validation
        int max_row = grid.length;
        int max_col = grid[0].length;
        // queue
        LinkedList<GridPoint> queue = new LinkedList<GridPoint>();
        // visited
        boolean[][] visited = new boolean[max_row][max_col];
        GridPoint s = new GridPoint(sr, sc, 0);
        queue.add(s);
        GridPoint curr;

        while (!queue.isEmpty()) {
            curr = queue.removeFirst();
            if (grid[curr.row][curr.col] == 0) continue;
            if (visited[curr.row][curr.col] == true) continue;
            visited[curr.row][curr.col] = true;

            if (curr.row == tr && curr.col == tc) { // check if target reached
                return curr.len;
            } else { // search its children / neighbors
                //add neighbors
                if (curr.row > 0) queue.add(new GridPoint(curr.row-1, curr.col, curr.len + 1)); // up
                if (curr.row < max_row - 1) queue.add(new GridPoint(curr.row+1, curr.col, curr.len + 1)); // down
                if (curr.col > 0) queue.add(new GridPoint(curr.row, curr.col-1, curr.len + 1)); // left
                if (curr.col < max_col - 1) queue.add(new GridPoint(curr.row, curr.col+1, curr.len + 1)); // right
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[][] input = {   {1,1,1,1,1},
                            {1,0,0,1,1},
                            {0,1,1,0,1},
                            {1,1,1,1,1}};

        System.out.println(shortestCellPath(input, 0, 0, 2, 1));

    }

    private static class GridPoint {
        public int len;
        public int row;
        public int col;

        public GridPoint(int row, int col, int len) {
            this.row = row;
            this.col = col;
            this.len = len;
        }
    }
}