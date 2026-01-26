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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMid(head);

        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return mergeTwoLists(left, right);
    }

    public ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (prev != null) prev.next = null; // 🔥 key line

        return slow;
    }

    public ListNode mergeTwoLists(ListNode n1, ListNode n2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (n1 != null && n2 != null) {
            if (n1.val <= n2.val) {
                tail.next = n1;
                n1 = n1.next;
            } else {
                tail.next = n2;
                n2 = n2.next;
            }
            tail = tail.next;
        }

        tail.next = (n1 != null) ? n1 : n2;
        return dummy.next;
    }
}
