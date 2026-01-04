class Solution {
    public String convert(String s, int n) {
        if (n == 1 || n >= s.length()) return s;
        
        StringBuilder[] r = new StringBuilder[n];
        for (int i = 0; i < n; i++) r[i] = new StringBuilder();
        
        int i = 0, d = 1;
        for (char c : s.toCharArray()) {
            r[i].append(c);
            i += d;
            if (i == 0 || i == n - 1) d = -d;
        }
        
        StringBuilder a = new StringBuilder();
        for (StringBuilder b : r) a.append(b);
        return a.toString();
    }
}