class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        int count=0;
        for(int num:nums){
            int fccount=hm.getOrDefault(num,0);
            count+=fccount;
            hm.put(num,fccount+1);
        }
        return count;
        /*int count=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]==nums[j])count++;
            }
        }
        return count;*/
    }
}