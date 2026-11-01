class Solution {
    public int minMoves(int[] nums) {
        int a=Integer.MAX_VALUE,b=0;
        for(int i:nums){a=Math.min(a,i);}
        for(int i:nums){b+=i-a;}
        return b;
    }
}