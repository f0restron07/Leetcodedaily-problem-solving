class Solution {
    int MOD = 1_000_000_007;
    List<Integer> possibleSubtreeSum;

    private int dfs(TreeNode currentNode) {
        if (currentNode == null) return 0;

        int currentSum = currentNode.val;
        currentSum += dfs(currentNode.left);
        currentSum += dfs(currentNode.right);
        possibleSubtreeSum.add(currentSum);

        return currentSum;
    }

    public int maxProduct(TreeNode root) {
        possibleSubtreeSum = new ArrayList<>();
        long totalSum = dfs(root); 

        long maxProduct = 0;

        for (int sum1 : possibleSubtreeSum) {
            long sum2 = totalSum - sum1;
            long product = sum1 * sum2;
            if (product > maxProduct) {
                maxProduct = product;
            }
        }

        return (int) (maxProduct % MOD);
    }
}