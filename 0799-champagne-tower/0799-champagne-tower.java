class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[101][101];
        dp[0][0] = poured;
        for (int i = 0; i <= query_row; i++)
            for (int j = 0; j <= i; j++)
                if (dp[i][j] > 1) {
                    double ex = (dp[i][j] - 1) / 2.0;
                    dp[i][j] = 1;
                    dp[i+1][j] += ex;
                    dp[i+1][j+1] += ex;
                }
        return dp[query_row][query_glass];
    }
}