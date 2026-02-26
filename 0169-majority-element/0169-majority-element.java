class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer>map=new HashMap<>();
        int maxele=nums[0],count=0;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            if (map.get(nums[i]) > count) {
                count = map.get(nums[i]);
                maxele = nums[i];
            }
        }return maxele;
    }
}