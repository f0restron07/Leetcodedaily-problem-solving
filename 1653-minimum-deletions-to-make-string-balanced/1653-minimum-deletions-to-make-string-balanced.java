class Solution {
    public int minimumDeletions(String s) {
        int cntb=0;
        int del=0;
        for(char c:s.toCharArray()){
            if(c=='b'){
            cntb++;}
            else del=Math.min(del+1,cntb);
        }
        return del;
    }
}