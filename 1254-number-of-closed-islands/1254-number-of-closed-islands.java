class Solution {
    public int closedIsland(int[][] grid) {
        int a = grid.length;
        int b = grid[0].length;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if ((i == 0 || i == a - 1 || j == 0 || j == b - 1) && grid[i][j] == 0) {
                    fill(grid, i, j);
                }
            }
        }
        int c = 0;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (grid[i][j] == 0) {
                    fill(grid, i, j);
                    c++;
                }
            }
        }
        return c;
    }
    void fill(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 0) {
            return;
        }
        grid[i][j] = 1;
        fill(grid, i - 1, j);
        fill(grid, i + 1, j);
        fill(grid, i, j - 1);
        fill(grid, i, j + 1);
    }
}