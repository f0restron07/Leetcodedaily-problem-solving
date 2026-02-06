class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int j=0;
        int ans=0;
        for(int i=0;i<nums.length;i++){
            while(j<=i && nums[i]>(long)k*nums[j]){
                j++;
            }
              ans=Math.max(ans,i-j+1);
        }
        return nums.length-ans;
    }
}