/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null){
            return null;
        }
        Node leftmost=root;
        while(leftmost.left!=null){
            Node currnode=leftmost;
            while(currnode!=null){
                currnode.left.next=currnode.right;
                if(currnode.next!=null){
                    currnode.right.next=currnode.next.left;
                }currnode = currnode.next;
            }
            leftmost=leftmost.left;

        }
        return root;
    }
}