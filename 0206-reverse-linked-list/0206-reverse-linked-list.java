class Solution {
    private ListNode head;
    private ListNode tail;

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        this.head = head;
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        this.tail = temp;
        reverse(head);
        return this.head;
    }

    private void reverse(ListNode node) {
        if (node == tail) {
            head = tail;
            return;
        }
        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }
}