import java.util.*;

class Solution {
    public int[] rearrangeArray(int[] nums) {
        
        Queue<Integer> posQueue = new LinkedList<>();
        Queue<Integer> negQueue = new LinkedList<>();
        

        for (int num : nums) {
            if (num > 0) {
                posQueue.offer(num);
            } else {
                negQueue.offer(num);
            }
        }
        
        int[] result = new int[nums.length];
        int index = 0;
        

        while (!posQueue.isEmpty() && !negQueue.isEmpty()) {
            result[index++] = posQueue.poll();
            result[index++] = negQueue.poll();
        }
        
        return result;
    }
}