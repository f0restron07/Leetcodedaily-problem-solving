class Solution {
    public int minimumCost(int[] nums) {
        int two = Integer.MAX_VALUE, three = Integer.MAX_VALUE;
        for(int i=1; i<nums.length; i++){
            if(nums[i] < three){
                two = three;
                three = nums[i];
            }
            else if(nums[i] < two && nums[i] >= three){
                two = nums[i];
            }
        }

        return two + three + nums[0];
        
    }
}