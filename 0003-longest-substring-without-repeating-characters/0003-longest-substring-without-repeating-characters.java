class Solution {
    public int lengthOfLongestSubstring(String s) {
        int a = 0, max = 0;
        HashMap<Character, Integer> last = new HashMap<>();

        for (int b = 0; b < s.length(); b++) {
            char c = s.charAt(b);

            if (last.containsKey(c)) {
                a = Math.max(a, last.get(c) + 1);
            }

            last.put(c, b);
            max = Math.max(max, b - a + 1);
        }
        return max;
    }
}
