class Solution {
    public boolean hasAllCodes(String s, int k) {
        int need = 1 << k;
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            set.add(s.substring(i, i + k));
            if (set.size() == need) {
                return true;
            }
        }
        return false;
    }
}