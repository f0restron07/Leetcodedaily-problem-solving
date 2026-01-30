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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];

        // 1. Count total nodes
        int n = 0;
        ListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        // 2. Compute base size and extra nodes
        int base = n / k;
        int extra = n % k;

        // 3. Split the list
        temp = head;
        for (int i = 0; i < k; i++) {
            if (temp == null) {
                result[i] = null;
                continue;
            }

            result[i] = temp;
            int size = base + (extra > 0 ? 1 : 0);
            extra--;

            // move to the last node of this part
            for (int j = 1; j < size; j++) {
                temp = temp.next;
            }

            // cut the list
            ListNode next = temp.next;
            temp.next = null;
            temp = next;
        }

        return result;
    }
}
