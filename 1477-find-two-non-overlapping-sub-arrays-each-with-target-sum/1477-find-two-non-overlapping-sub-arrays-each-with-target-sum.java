class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n=arr.length;
        int[] best=new int[n];
        int INF=Integer.MAX_VALUE;
        int ans=INF;
        int left=0;
        long sum=0;
        int minLen=INF;
        for(int right=0;right<n;right++){
            sum+=arr[right];
            while(sum>target){
                sum-=arr[left];
                left++;
            }
            if(sum==target){
                int curLen=right-left+1;
                if(left>0&&best[left-1]!=INF){
                    ans=Math.min(ans,curLen+best[left-1]);
                }
                minLen=Math.min(minLen,curLen);
            }
            best[right]=minLen;
        }
        return ans==INF?-1:ans;
    }
}