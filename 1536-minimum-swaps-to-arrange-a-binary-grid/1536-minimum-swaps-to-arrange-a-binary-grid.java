class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int step = 0;
        int[] zeroInTail = new int[n];
        for (int i = 0; i < n; i++){
            int zero = 0;
            while (zero <= n-1 && grid[i][n-1-zero] == 0) zero++;
            zeroInTail[i] = zero;
        }
        for (int i = 0; i < n-1; i++){
            boolean found = false;
            for (int j = i; j < n; j++){
                if (zeroInTail[j] >= n-1-i){
                    step += j-i;
                    swap(zeroInTail, i, j);
                    found = true;
                    break;
                }
            }
            if (!found) return -1;
        }
        return step;
    }
    private void swap(int[] nums, int start, int end){
        for (int i = end; i > start; i--){
            nums[i] = nums[i-1];
        }
    }
}