package algoProblemSolutions;

public class FindMaxIslandIn2DGrid {

    /*
    r
c       0 1 2 3

    0   0 1 1 1
          ^
    1   0 1 0 0
    2   1 0 1 0
    3   0 0 0 1
    4   1 1 1 1

    traverse all grid cells.
    if a grid cell is a 1 - we have reached land. do a dfs around it until all connected nodes are visited. keep a count of the all new nodes visited for each island.

    2 variants:
    find total islands
    find the largest island size.

    dfs(int r, int c, visited)

    */


    public int findMaxIslandSize(int[][] grid) {
        int max = 0;
        int[][] visited = new int[grid.length][grid[0].length];
        initVisited(visited);
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (visited[r][c] == -1 && grid[r][c] == 1) {
                    max = Math.max(max, dfsWithSize(r, c, grid, visited));
                }
            }
        }
        return max;
    }

    public int findTotalIslands(int[][] grid) {
        int count = 0;
        int[][] visited = new int[grid.length][grid[0].length];
        initVisited(visited);
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (visited[r][c] == -1 && grid[r][c] == 1) {
                    dfs(r, c, grid, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int row, int col, int[][] grid, int[][] visited) {
        if (visited[row][col] != 1) {
            visited[row][col] = 1;
            if (row > 0 && grid[row-1][col] == 1) dfs(row-1, col, grid, visited); // go up
            if (row < grid.length - 1 && grid[row+1][col] == 1) dfs(row+1, col, grid, visited); // go down
            if (col > 0 && grid[row][col-1] == 1) dfs(row, col-1, grid, visited); // go left
            if (col < grid[0].length - 1 && grid[row][col+1] == 1) dfs(row, col+1, grid, visited); // go right
        }
    }

    public int dfsWithSize(int row, int col, int[][] grid, int[][] visited) {
        int count = 0;
        if (visited[row][col] != 1) {
            count++;
            visited[row][col] = 1;
            if (row > 0 && grid[row-1][col] == 1)
                count += dfsWithSize(row-1, col, grid, visited); // go up
            if (row < grid.length - 1 && grid[row+1][col] == 1)
                count += dfsWithSize(row+1, col, grid, visited); // go down
            if (col > 0 && grid[row][col-1] == 1)
                count += dfsWithSize(row, col-1, grid, visited); // go left
            if (col < grid[0].length - 1 && grid[row][col+1] == 1)
                count += dfsWithSize(row, col+1, grid, visited); // go right
        }
        return count;
    }

    private void initVisited(int[][] visited) {
        for (int r = 0; r < visited.length; r++) {
            for (int c = 0; c < visited[0].length; c++) {
                visited[r][c] = -1;
            }
        }
    }


    public static void main(String[] args) {
        int[][] input = {   {1,1,0,1,1,1},
                            {1,1,1,0,0,0},
                            {1,0,0,1,0,0},
                            {1,0,0,1,0,1},
                            {1,0,0,0,0,1},
                            {0,0,0,1,0,1},
                            {0,1,1,1,1,1}};

        FindMaxIslandIn2DGrid ob = new FindMaxIslandIn2DGrid();
        System.out.println("total islands: " + ob.findTotalIslands(input));
        System.out.println("max island size: " + ob.findMaxIslandSize(input));

    }


}
