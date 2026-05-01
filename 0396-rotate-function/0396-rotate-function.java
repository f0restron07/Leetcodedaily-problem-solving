class Solution {
    public int maxRotateFunction(int[] nums) {
       int n = nums.length;
       int sum = 0; 
       int fsum = 0;
       
        for(int i=0; i<n; i++){
           sum +=nums[i];
           fsum +=i*(nums[i]);
        
        }
        int max  = fsum;
        for(int i=1; i<n; i++){

            fsum = fsum +sum-n*nums[n-i];
          max= Math.max(fsum,max);
        }
        return max;
    }
}