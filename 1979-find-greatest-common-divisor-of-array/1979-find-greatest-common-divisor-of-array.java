class Solution {
    public int findGCD(int[] nums) {
        int a=nums[0];
        int b=nums[0];
        for(int x:nums){
            a=Math.min(a,x);
            b=Math.max(b,x);
        }
        while(b!=0){
            int c=a%b;
            a=b;
            b=c;
        }
        return a;
    }
}