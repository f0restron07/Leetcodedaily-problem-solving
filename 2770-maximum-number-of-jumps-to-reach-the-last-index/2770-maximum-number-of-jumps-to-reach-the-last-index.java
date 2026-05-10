class Solution {
    int[][] dp;

    public int solve(int[] nums,int target,int i,int j,int n){
        if(i>=n-1){
            return 0;
        }

        if(j>n-1) return Integer.MIN_VALUE;

        if(dp[i][j]!=-2) return dp[i][j];

        boolean flag = Math.abs(nums[j]-nums[i])<=target;
        
        int take = Integer.MIN_VALUE;

        if(flag) take = 1 + solve(nums,target,j,j+1,n);


        int skip = solve(nums,target,i,j+1,n);

        return dp[i][j]=Math.max(take,skip);
    }

    public int maximumJumps(int[] nums, int target) {
        int n=nums.length;
        dp=new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-2);

        int ans = solve(nums,target,0,1,n);

        return (ans<0)?-1:ans;
    }
}