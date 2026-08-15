class Solution {
    public int longestSubsequence(int[] nums) {
        int x=0;
        for(int v:nums){
            x^=v;
        }
        if(x!=0){
            return nums.length;
        }
        boolean anyNonZero=false;
        for(int v:nums){
            if(v!=0){
                anyNonZero=true;
                break;
            }
        }
        return anyNonZero?nums.length-1:0;
    }
}