class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int initialcolor = image[sr][sc];
        int[][] ans = image;
        int[] delRow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        dfs(sr, sc, ans, image, delRow, delcol, newColor, initialcolor);
        return ans;
    }

    private void dfs(int sr, int sc, int[][] ans, int[][] image, int[] delRow, int[] delcol, int newColor, int initialcolor) {
        ans[sr][sc] = newColor;
        int n = image.length;
        int m = image[0].length;
        for (int i = 0; i < 4; i++) {
            int currrow = delRow[i] + sr;
            int currcol = delcol[i] + sc;
            if (currrow >= 0 && currrow < n && currcol >= 0 && currcol < m
                    && image[currrow][currcol] == initialcolor && ans[currrow][currcol] != newColor) {
                dfs(currrow, currcol, ans, image, delRow, delcol, newColor, initialcolor);
            }
        }
    }
}