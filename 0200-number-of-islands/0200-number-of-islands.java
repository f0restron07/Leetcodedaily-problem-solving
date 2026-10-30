
class Pair {
    int first, second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    cnt++;
                    bfs(i, j, vis, grid);
                }
            }
        }
        return cnt;
    }

    private void bfs(int row, int col, boolean[][] vis, char[][] grid) {
        vis[row][col] = true;
        int r = grid.length;
        int c = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        while (!q.isEmpty()) {
            int currrow = q.peek().first;
            int currcol = q.peek().second;
            q.remove();
            int[] delrow = {-1, 0, 1, 0};
int[] delcol = {0, 1, 0, -1};
for (int k = 0; k < 4; k++) {
    int nowrow = currrow + delrow[k];
    int nowcol = currcol + delcol[k];
    if (nowrow >= 0 && nowrow < r && nowcol >= 0 && nowcol < c
            && grid[nowrow][nowcol] == '1' && !vis[nowrow][nowcol]) {
        vis[nowrow][nowcol] = true;
        q.add(new Pair(nowrow, nowcol));
    }
}
        }
    }
}