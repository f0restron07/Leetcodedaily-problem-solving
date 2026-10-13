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
    private TreeNode root;
 
    public TreeNode sortedArrayToBST(int[] nums) {
        populateSorted(nums, 0, nums.length);
        return root;
    }
 
    private void populateSorted(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
 
        root = insert(nums[mid], root);
        populateSorted(nums, start, mid);
        populateSorted(nums, mid + 1, end);
    }
 
    private TreeNode insert(int value, TreeNode node) {
        if (node == null) {
            node = new TreeNode(value);
            return node;
        }
        if (value < node.val) {
            node.left = insert(value, node.left);
        }
        if (value > node.val) {
            node.right = insert(value, node.right);
        }
        return node;
    }
}