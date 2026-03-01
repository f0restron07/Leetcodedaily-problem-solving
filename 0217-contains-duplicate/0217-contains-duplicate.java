class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer>set=new HashSet<>();
        for(int num:nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;//O(N)
        /*//Brute Force
        int count=0;
        if(nums.length<2){
            return false;
        }
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    count++;
                    return true;
                }
            }
        }
        return false;
        O(n^2)*/
    }
}