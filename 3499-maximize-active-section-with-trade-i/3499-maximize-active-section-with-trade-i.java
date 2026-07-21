class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        String t="1"+s+"1";
        int n=t.length();
        int ones=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                ones++;
            }
        }
        int prev=0;
        int best=0;
        int i=0;
        while(i<n){
            if(t.charAt(i)=='0'){
                int j=i;
                while(j<n&&t.charAt(j)=='0'){
                    j++;
                }
                int len=j-i;
                if(prev>0){
                    best=Math.max(best,prev+len);
                }
                prev=len;
                i=j;
            }else{
                i++;
            }
        }
        return ones+best;
    }
}