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
    public ListNode mergeTwoLists(ListNode n1, ListNode n2) {
        ListNode temp = new ListNode(-1);
        ListNode tail = temp;

        while (n1 != null && n2 != null){
            if (n1.val < n2.val){
                tail.next = n1;
                n1 = n1.next;
            }else{
                tail.next = n2;
                n2 = n2.next;
            }
            tail = tail.next;
        }
        if (n1 != null){
            tail.next = n1;
        }else{
            tail.next = n2;
        }

        return temp.next;
    }
}