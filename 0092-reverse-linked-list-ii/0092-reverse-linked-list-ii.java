class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode leftprev = dummy;
        ListNode pres = head;
        for (int i = 0; i < left - 1; i++) {
            leftprev = leftprev.next;
            pres = pres.next;
        }

        ListNode sublisthead = pres;

        ListNode prev = null;
        for (int i = 0; i <= right - left; i++) {
            ListNode next = pres.next;
            pres.next = prev;
            prev = pres;
            pres = next;
        }

        leftprev.next = prev;
        sublisthead.next = pres;

        return dummy.next;
    }
}