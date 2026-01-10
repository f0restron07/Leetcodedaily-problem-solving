class Solution {
    Integer[][] dp;

    public int minimumDeleteSum(String s1, String s2) {
        dp = new Integer[s1.length()][s2.length()];
        return solve(0, 0, s1, s2);
    }

    private int solve(int i, int j, String s1, String s2) {
        if (i == s1.length()) {
            int sum = 0;
            for (int k = j; k < s2.length(); k++) {
                sum += s2.charAt(k);
            }
            return sum;
        }

        if (j == s2.length()) {
            int sum = 0;
            for (int k = i; k < s1.length(); k++) {
                sum += s1.charAt(k);
            }
            return sum;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = solve(i + 1, j + 1, s1, s2);
        } else {
            int deleteFromS1 = s1.charAt(i) + solve(i + 1, j, s1, s2);
            int deleteFromS2 = s2.charAt(j) + solve(i, j + 1, s1, s2);
            return dp[i][j] = Math.min(deleteFromS1, deleteFromS2);
        }
    }
}