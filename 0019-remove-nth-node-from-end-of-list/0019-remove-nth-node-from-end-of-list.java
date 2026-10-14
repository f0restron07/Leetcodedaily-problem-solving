/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int countnoofnodes=0;
        ListNode temp=head;
        while(temp!=null){
            countnoofnodes+=1;
            temp=temp.next;
        }
        int nodetoremove=countnoofnodes-n;
        if (nodetoremove == 0) {
            return head.next;
        }
        ListNode prev=head;
        for(int i=1;i<nodetoremove;i++){
            prev=prev.next;
        }
        prev.next=prev.next.next;
        return head;
    }
}