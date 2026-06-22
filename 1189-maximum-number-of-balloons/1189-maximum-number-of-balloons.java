class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] count = new int[26];
        for (char c : text.toCharArray()) {
            count[c - 'a']++;
        }
        int instance = 0;
        while (count['b'-'a']>0 && count['a'-'a']>0 && count['l'-'a']>1 
               && count['o'-'a']>1 && count['n'-'a']>0) {
            count['b'-'a']--;
            count['a'-'a']--;
            count['l'-'a']-=2;
            count['o'-'a']-=2;
            count['n'-'a']--;
            instance++;
        }
        return instance;
    }
}