class Solution{
    public int longestBalanced(String s){
        int n=s.length();
        int ans=0;
        for(int i=0;i<n;i++){
            int[] freq=new int[26];
            for(int j=i;j<n;j++){
                freq[s.charAt(j)-'a']++;
                if(check(freq))
                    ans=Math.max(ans,j-i+1);
            }
        }
        return ans;
    }
    public boolean check(int[] freq){
        int val=0;
        for(int f:freq){
            if(f>0){
                if(val==0)val=f;
                else if(val!=f)return false;
            }
        }
        return true;
    }
}