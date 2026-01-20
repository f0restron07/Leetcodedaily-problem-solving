class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
     int res[] = new int[nums.size()];
     int ind = 0;
     for(int i: nums){
        if(i==2){
            res[ind++] = -1;
            continue;
        }
        int k = 1;
        while((k & i) != 0){
            k = k << 1;
        }
        k = k >> 1;
        res[ind++] = (i ^ k); 
     }

     return res;   
    }
}