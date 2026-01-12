class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }

    private ListNode add(ListNode l1, ListNode l2, int carry) {
        // base case
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        int sum = carry;

        if (l1 != null) sum += l1.val;
        if (l2 != null) sum += l2.val;

        ListNode node = new ListNode(sum % 10);

        node.next = add(
            l1 != null ? l1.next : null,
            l2 != null ? l2.next : null,
            sum / 10
        );

        return node;
    }
}
