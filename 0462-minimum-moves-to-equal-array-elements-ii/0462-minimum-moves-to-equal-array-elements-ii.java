class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        long a = 0;
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) a += (long) nums[j] - nums[i];
        return (int) a;
    }
}