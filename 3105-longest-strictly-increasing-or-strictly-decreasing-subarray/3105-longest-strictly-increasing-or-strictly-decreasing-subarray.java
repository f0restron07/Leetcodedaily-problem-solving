class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n=nums.length,a=1,b=0,c=1;
        for(int i=1;i<n;i++){
            int d=Integer.compare(nums[i],nums[i-1]);
            if(d==0){
                a=1;
            }else if(d==b){
                a++;
            }else{
                a=2;
            }
            b=d;
            c=Math.max(c,a);
        }
        return c;
    }
}