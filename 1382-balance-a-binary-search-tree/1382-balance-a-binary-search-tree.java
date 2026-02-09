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
    static ArrayList<TreeNode> sortedTree;
    static void inorder(TreeNode root) {
        if(root == null) {
            return;
        }

        inorder(root.left);
        sortedTree.add(root);
        inorder(root.right);
    }
    static TreeNode createBalancedBST(int si, int ei) {
        if(si > ei) {
            return null;
        }

        int mid = si + (ei - si) / 2;
        TreeNode root = sortedTree.get(mid);
        root.left = createBalancedBST(si, mid-1);
        root.right = createBalancedBST(mid+1, ei);

        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        sortedTree = new ArrayList<>();
        inorder(root);
        TreeNode bstRoot = createBalancedBST(0, sortedTree.size() - 1);
        return bstRoot;
    }
}