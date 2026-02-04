class Solution {
    int n;
    ArrayList<ArrayList<Long>> memo;

    public long maxSumTrionic(int[] nums) {
        n = nums.length;
        memo = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Long> row = new ArrayList<>(Collections.nCopies(4, null));
            memo.add(row);
        }

        return solve(0, nums, 0);
    }

    long solve(int i, int[] arr, int trend) {
        // Base condition
        if (i == n) {
            if (trend == 3) {
                return 0;
            } else {
                return Long.MIN_VALUE / 2;
            }
        }

        long take = Long.MIN_VALUE / 2;
        long skip = Long.MIN_VALUE / 2;

        if (memo.get(i).get(trend) != null) {
            return memo.get(i).get(trend);
        }

        if (trend == 0) {
            skip = solve(i + 1, arr, 0);
        }

        if (trend == 3) {
            take = arr[i];
        }

        if (i + 1 < n) {
            long curr = arr[i];
            long next = arr[i + 1];

            if (trend == 0 && curr < next) {
                take = Math.max(take, curr + solve(i + 1, arr, 1));
            } else if (trend == 1) { // For Increasing
                if (curr < next) {
                    take = Math.max(take, curr + solve(i + 1, arr, 1));
                } else if (curr > next) {
                    take = Math.max(take, curr + solve(i + 1, arr, 2));
                }
            } else if (trend == 2) { // For Decreasing
                if (curr > next) {
                    take = Math.max(take, curr + solve(i + 1, arr, 2));
                } else if (curr < next) {
                    take = Math.max(take, curr + solve(i + 1, arr, 3));
                }
            } else if (trend == 3 && curr < next) { // Increaing 
                take = Math.max(take, curr + solve(i + 1, arr, 3));
            }

        }
        long ans = Math.max(take, skip);
        memo.get(i).set(trend, ans);
        return ans;
    }
}