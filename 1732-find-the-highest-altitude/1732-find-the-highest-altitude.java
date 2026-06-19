class Solution {
    public int largestAltitude(int[] gain) {
        int a=0;
        int b=0;
        for(int g:gain){
            a+=g;
            b=Math.max(b,a);
        }
        return b;
    }
}