class Solution {
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
