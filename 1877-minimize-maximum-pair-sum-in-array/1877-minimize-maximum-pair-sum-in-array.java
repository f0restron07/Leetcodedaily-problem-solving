class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int m=n/2;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<m;i++){
            max=Math.max(max,nums[i]+nums[n-1-i]);
        }
        return max;
    }
}