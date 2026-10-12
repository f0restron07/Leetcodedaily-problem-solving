import java.util.*;

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            int chcount = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                int sameparent = 0;

                if (node.left != null) {
                    if (node.left.val == x || node.left.val == y) {
                        chcount++;
                        sameparent++;
                    }
                    q.offer(node.left);
                }
                if (node.right != null) {
                    if (node.right.val == x || node.right.val == y) {
                        chcount++;
                        sameparent++;
                    }
                    q.offer(node.right);
                }

                if (sameparent == 2) return false;
            }

            if (chcount == 2) return true;
            if (chcount == 1) return false;
        }
        return false;
    }
}