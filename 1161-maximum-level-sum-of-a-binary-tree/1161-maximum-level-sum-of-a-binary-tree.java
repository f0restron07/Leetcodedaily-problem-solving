/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxLevelSum(TreeNode root) {

        long sum = 0;
        int level = 1;
        long[] levelSum = new long[10000]; // to store level sum of each tree level

        int maxLevel = levelOrder(root, level, levelSum);

        // find min idx of level sum
        int maxSumIdx = Integer.MAX_VALUE; // idx should be as small as possible
        long maxSum = Integer.MIN_VALUE;

        for(int curLevel=1; curLevel <= maxLevel; curLevel++) {
            if(levelSum[curLevel] > maxSum) {
                maxSum = levelSum[curLevel];
                maxSumIdx = curLevel;
                
            }
        }

        return maxSumIdx;
        
    }

    private int levelOrder(TreeNode node, int level, long[] levelSum) {
        if(node == null) return level - 1;

        // level sum
        levelSum[level] = node.val + levelSum[level];

        int leftLevel = levelOrder(node.left, level+1, levelSum);
        int rightLevel = levelOrder(node.right, level+1, levelSum);

        return Math.max(leftLevel, rightLevel);


    }
}