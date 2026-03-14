class Solution {
    int k;

    public String getHappyString(int n, int k) {
        this.k = k;
        int total = 3 * (1 << (n - 1));
        if (k > total) return "";
        return dfs(n, (char)0);
    }

    private String dfs(int n, char prev) {
        if (n == 0) return --k == 0 ? "" : null;

        for (char c = 'a'; c <= 'c'; c++) {
            if (c == prev) continue;

            String res = dfs(n - 1, c);
            if (res != null)
                return c + res;
        }

        return null;
    }
}