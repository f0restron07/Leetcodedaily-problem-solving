class Solution {
    private int solve(String s, char skip) {
        int mlen = 0;

        char first = (skip == 'a') ? 'b' : 'a';
        char second = (skip == 'c') ? 'b' : 'c';

        int i = 0, n = s.length();

        while(i < n) {
            int c1 = 0, c2 = 0;
            Map<Integer, Integer> prev = new HashMap<>();
            prev.put(0, i - 1);

            while(i < n && s.charAt(i) != skip) {
                char ch = s.charAt(i);

                if(ch == first) c1++;
                else c2++;

                int diff = c1 - c2;

                if(prev.containsKey(diff)) {
                    mlen = Math.max(mlen, i - prev.get(diff));
                }else {
                    prev.put(diff, i);
                }

                i++;
            }
            i++;
        }
        return mlen;
    }

    public int longestBalanced(String s) {
        int n = s.length();
        int maxLen = 0;

        for(int i = 0; i < n;) {
            char ch = s.charAt(i);
            int j = i;

            while(j < n && s.charAt(j) == ch) {
                j++;
            }

            int len = j - i;

            maxLen = Math.max(maxLen, len);
            i = j;
        }

        maxLen = Math.max(maxLen, solve(s, 'c'));
        maxLen = Math.max(maxLen, solve(s, 'b'));
        maxLen = Math.max(maxLen, solve(s, 'a'));

        Map<String, Integer> prev = new HashMap<>();
        int c1 = 0, c2 = 0, c3 = 0;

        prev.put("0#0", -1);

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == 'a') c1++;
            else if(ch == 'b') c2++;
            else c3++;

            String key = (c1 - c3) + "#" + (c2 - c3);

            if(prev.containsKey(key)) {
                maxLen = Math.max(maxLen, i - prev.get(key));
            }else {
                prev.put(key, i);
            }
        }
        return maxLen;
    }
}