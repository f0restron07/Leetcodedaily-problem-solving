class Solution {
    public int minimumPairRemoval(int[] nums) {
        int count = 0, lastEleInd = nums.length - 1;
        if (lastEleInd == 0)
            return 0;
        while (!isSorted(nums, lastEleInd)) {
            int mergeInd = 0, pairSum = Integer.MAX_VALUE;
            for (int i = 0; i < lastEleInd; i++) {
                int curSum = nums[i] + nums[i + 1];
                if (curSum < pairSum) {
                    pairSum = curSum;
                    mergeInd = i;
                }
            }
            mergeElements(nums, mergeInd, lastEleInd);
            count++;
            lastEleInd--;
        }
        return count;
    }

    public boolean isSorted(int[] nums, int lastEleInd) {
        for (int i = 0; i < lastEleInd; i++) {
            if (nums[i] > nums[i + 1])
                return false;
        }
        return true;
    }

    public void mergeElements(int[] nums, int ind, int lastEleInd) {
        nums[ind] += nums[ind + 1];
        for (int i = ind + 1; i < lastEleInd; i++) {
            nums[i] = nums[i + 1];
        }
    }
}