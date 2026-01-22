import java.util.*;

class Solution {

    // Find index of adjacent pair with minimum sum
    private int minPairSum(List<Integer> nums) {
        int minSum = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < nums.size() - 1; i++) {
            int sum = nums.get(i) + nums.get(i + 1);
            if (sum < minSum) {
                minSum = sum;
                index = i;
            }
        }
        return index;
    }

    // Check if list is sorted in non-decreasing order
    private boolean isSorted(List<Integer> nums) {
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < nums.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    public int minimumPairRemoval(int[] arr) {
        List<Integer> nums = new ArrayList<>();
        for (int x : arr) nums.add(x);

        int operations = 0;

        while (!isSorted(nums)) {
            int index = minPairSum(nums);

            // Merge nums[index] and nums[index+1]
            nums.set(index, nums.get(index) + nums.get(index + 1));
            nums.remove(index + 1);

            operations++;
        }

        return operations;
    }
}
