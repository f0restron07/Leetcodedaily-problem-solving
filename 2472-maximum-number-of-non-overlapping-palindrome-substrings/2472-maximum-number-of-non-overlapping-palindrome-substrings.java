class Solution {
    public int maxPalindromes(String s, int k) {
        int n=s.length();
        int count=0;
        int start=0;
        for(int end=0;end<n;end++){
            for(int L=k;L<=k+1;L++){
                int left=end-L+1;
                if(left>=start&&left>=0){
                    if(isPal(s,left,end)){
                        count++;
                        start=end+1;
                        break;
                    }
                }
            }
        }
        return count;
    }
    boolean isPal(String s,int a,int b){
        while(a<b){
            if(s.charAt(a)!=s.charAt(b)){
                return false;
            }
            a++;
            b--;
        }
        return true;
    }
}