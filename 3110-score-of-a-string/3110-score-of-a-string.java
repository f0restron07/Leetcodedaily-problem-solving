class Solution {
    public int scoreOfString(String s) {
        int n=s.length();
        int absval=0;
        for(int i=1;i<n;i++){
            absval=absval+Math.abs(s.charAt(i)-s.charAt(i-1));
        }
        return absval;
    }
}