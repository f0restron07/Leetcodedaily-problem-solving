class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int i = 0;
        int j = n - 1;
        int maxSum = 0;
        while (i < j) { 
            maxSum = Math.max(maxSum, nums[i] + nums[j]);
            i++;
            j--;
        }
        return maxSum;
    }

    public int minPairSumUsingBinarySearch(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int low = nums[0] + nums[n - 1];      
        int high = nums[n - 2] + nums[n - 1]; 
        while (low <= high) {                 
            int mid = low + (high - low) / 2;
            if (canFormSum(nums, n, mid)) {   
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    private boolean canFormSum(int[] nums, int n, int target) {
        int maxSum = 0;
        int i = 0;
        int j = n - 1;
        while (i < j) { 
            int currentSum = nums[i] + nums[j];
            maxSum = Math.max(maxSum, currentSum);
            i++;
            j--;
        }
        return maxSum <= target;
    }
}