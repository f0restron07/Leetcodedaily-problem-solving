class Solution {
    public int uniquePaths(int[][] grid) {
        int a = grid.length, b = grid[0].length, c = 1_000_000_007;
        long[][] d = new long[a][b], e = new long[a][b];
        d[0][0] = 1;
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (j > 0) d[i][j] = (grid[i][j - 1] == 0 ? d[i][j - 1] + e[i][j - 1] : e[i][j - 1]) % c;
                if (i > 0) e[i][j] = (grid[i - 1][j] == 0 ? d[i - 1][j] + e[i - 1][j] : d[i - 1][j]) % c;
            }
        }
        return (int) ((d[a - 1][b - 1] + e[a - 1][b - 1]) % c);
    }
}