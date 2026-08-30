class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        int mi=0;
        int ma=0;
        for(int k=0;k<n;k++){
            if(nums[k]<nums[mi]){
                mi=k;
            }
            if(nums[k]>nums[ma]){
                ma=k;
            }
        }
        int i=Math.min(mi,ma);
        int j=Math.max(mi,ma);
        int frontBoth=j+1;
        int backBoth=n-i;
        int split=(i+1)+(n-j);
        return Math.min(frontBoth,Math.min(backBoth,split));
    }
}