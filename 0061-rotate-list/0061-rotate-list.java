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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // 1. Find length
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        // 2. Handle large k
        k = k % len;
        if (k == 0) return head;

        // 3. Go to (len - k - 1)th node
        ListNode prev = head;
        for (int i = 1; i < len - k; i++) {
            prev = prev.next;
        }

        // 4. New head
        ListNode newHead = prev.next;

        // 5. Break link
        prev.next = null;

        // 6. Go to last node of newHead
        ListNode tail = newHead;
        while (tail.next != null) {
            tail = tail.next;
        }

        // 7. Connect tail to old head
        tail.next = head;

        return newHead;
    }
}
