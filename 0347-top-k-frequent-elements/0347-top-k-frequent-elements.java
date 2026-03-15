import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n,0) + 1);
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            int maxKey = -1;
            int maxFreq = -1;
            for(int key : map.keySet()){
                if(map.get(key) > maxFreq){
                    maxFreq = map.get(key);
                    maxKey = key;
                }
            }
            res[i] = maxKey;
            map.remove(maxKey);
        }

        return res;
    }
}