class Solution {
    int[][] dp;
    int[] pre;
    public int stoneGameV(int[] stoneValue) {
        int n=stoneValue.length;
        pre=new int[n+1];
        for(int i=0;i<n;i++){
            pre[i+1]=pre[i]+stoneValue[i];
        }
        dp=new int[n][n];
        for(int[] r:dp){
            Arrays.fill(r,-1);
        }
        return solve(0,n-1);
    }
    int sum(int i,int j){
        return pre[j+1]-pre[i];
    }
    int solve(int i,int j){
        if(i==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int best=0;
        for(int k=i;k<j;k++){
            int l=sum(i,k);
            int r=sum(k+1,j);
            if(l<r){
                best=Math.max(best,l+solve(i,k));
            }else if(l>r){
                best=Math.max(best,r+solve(k+1,j));
            }else{
                best=Math.max(best,l+Math.max(solve(i,k),solve(k+1,j)));
            }
        }
        return dp[i][j]=best;
    }
}