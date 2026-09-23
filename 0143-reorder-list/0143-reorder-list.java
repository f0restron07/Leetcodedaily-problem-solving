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
    public void reorderList(ListNode head) {
        if(head==null||head.next==null){
            return;
        }
        ListNode mid=middleNode(head);
        ListNode sh=reverse(mid);
        ListNode fsh=head;
        while(fsh!=null&&sh!=null){
            ListNode temp=fsh.next;
            fsh.next=sh;
            fsh=temp;
            temp=sh.next;
            sh.next=fsh;
            sh=temp;
        }
        if (fsh != null) {
        fsh.next = null;
    }
       
    }
    private ListNode reverse(ListNode node) {
    ListNode prev = null;
    while (node != null) {
        ListNode next = node.next;
        node.next = prev;
        prev = node;
        node = next;
    }
    return prev;
}

public ListNode middleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}
}