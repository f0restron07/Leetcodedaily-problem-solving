import java.util.HashMap;

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int maxCount = 0;
        int majority = 0;

        for(int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);

            if(count > maxCount) {
                maxCount = count;
                majority = num;
            }
        }

        return majority;
    }
}