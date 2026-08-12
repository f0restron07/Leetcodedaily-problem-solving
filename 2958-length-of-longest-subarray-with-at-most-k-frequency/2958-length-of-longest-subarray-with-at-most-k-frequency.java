class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> f=new HashMap<>();
        int i=0;
        int best=0;
        for(int j=0;j<nums.length;j++){
            f.merge(nums[j],1,Integer::sum);
            while(f.get(nums[j])>k){
                f.merge(nums[i],-1,Integer::sum);
                i++;
            }
            best=Math.max(best,j-i+1);
        }
        return best;
    }
}