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
    public int pairSum(ListNode head) {
        ListNode a=head;
        ListNode b=head;
        while(b!=null&&b.next!=null){
            a=a.next;
            b=b.next.next;
        }
        ListNode c=null;
        while(a!=null){
            ListNode d=a.next;
            a.next=c;
            c=a;
            a=d;
        }
        int e=0;
        ListNode f=head;
        while(c!=null){
            e=Math.max(e,f.val+c.val);
            f=f.next;
            c=c.next;
        }
        return e;
    }
}