class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] len = new long[n + 1];
        long CAP = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            long L = len[i];
            if (c == '*')      len[i+1] = Math.max(0, L - 1);
            else if (c == '#') len[i+1] = (L > CAP / 2) ? CAP : L * 2;
            else if (c == '%') len[i+1] = L;
            else               len[i+1] = L + 1;
        }
        if (k >= len[n]) return '.';
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            long before = len[i];
            if (c == '*') {
            } else if (c == '#') {
                if (k >= before) k -= before;
            } else if (c == '%') {
                k = before - 1 - k; 
            } else {
                if (k == before) return c;
            }
        }
        return '.';
    }
}