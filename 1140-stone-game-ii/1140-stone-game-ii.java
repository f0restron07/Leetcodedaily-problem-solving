class Solution {
    int[][] dp;
    int[] suf;
    int n;
    public int stoneGameII(int[] piles) {
        n=piles.length;
        suf=new int[n+1];
        for(int i=n-1;i>=0;i--){
            suf[i]=suf[i+1]+piles[i];
        }
        dp=new int[n][n+1];
        for(int[] r:dp){
            Arrays.fill(r,-1);
        }
        return solve(0,1);
    }
    int solve(int i,int m){
        if(i>=n){
            return 0;
        }
        if(i+2*m>=n){
            return suf[i];
        }
        if(dp[i][m]!=-1){
            return dp[i][m];
        }
        int best=0;
        for(int x=1;x<=2*m;x++){
            int take=suf[i]-solve(i+x,Math.max(m,x));
            best=Math.max(best,take);
        }
        return dp[i][m]=best;
    }
}]