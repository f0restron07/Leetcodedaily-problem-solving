class Solution {
    public int minimumDistance(String word) {
        int n = word.length(), ans = 0, max = 0;
        int[] dp = new int[26];
        for(int i = 0; i < n - 1; i++) {
            int finger1 = word.charAt(i) - 'A', target = word.charAt(i + 1) - 'A';
            int dist1 = dist(finger1, target);
            for(int finger2 = 0; finger2 < 26; finger2++) dp[finger1] = Math.max(dp[finger1], dp[finger2] + dist1 - dist(finger2, target));
            if(dp[finger1] > max) max = dp[finger1];
            ans += dist1;
        }
        return ans - max;
    }
    private int dist(int a, int b) {
        return Math.abs(a / 6 - b / 6) + Math.abs(a % 6 - b % 6);
    }
}