class Solution {
    public int sortPermutation(int[] nums) {
        int n=nums.length;
        int acc=-1;
        for(int i=0;i<n;i++){
            if(nums[i]!=i){
                acc=(acc==-1)?nums[i]:(acc&nums[i]);
            }
        }
        return acc==-1?0:acc;
    }
}