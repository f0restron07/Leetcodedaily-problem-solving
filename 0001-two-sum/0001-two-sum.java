class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer>map=new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<n;i++){
            int comp=target-nums[i];
            if(map.containsKey(comp)&&map.get(comp)!=i){
                return new int[]{i,map.get(comp)};
            }
        }
        return new int[]{};
    }
   
}