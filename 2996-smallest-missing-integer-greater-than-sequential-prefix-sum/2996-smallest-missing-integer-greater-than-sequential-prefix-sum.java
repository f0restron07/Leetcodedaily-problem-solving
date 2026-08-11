class Solution {
    public int missingInteger(int[] nums) {
        int sum=nums[0];
        int i=1;
        while(i<nums.length&&nums[i]==nums[i-1]+1){
            sum+=nums[i];
            i++;
        }
        boolean[] seen=new boolean[101]; 
        for(int x:nums){
            seen[x]=true;
        }
        int x=sum;
        while(x<=100&&seen[x]){
            x++;
        }
        return x;
    }
}