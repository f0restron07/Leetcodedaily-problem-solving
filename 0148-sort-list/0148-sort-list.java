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
        if(head==null||head.next==null){
            return head;
        }
        ListNode mid=getmid(head);
        ListNode left=sortList(head);
        ListNode right=sortList(mid);
        return mergeList(left,right);
    }
    private ListNode getmid(ListNode head){
        ListNode prev=null;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        if(prev!=null)prev.next=null;
        return slow;
    }
    private ListNode mergeList(ListNode first,ListNode second){
        ListNode dummy=new ListNode(-1);
        ListNode tail=dummy;
        while(first!=null&&second!=null){
            if(first.val<=second.val){
                tail.next=first;
                first=first.next;
            }else{
                tail.next=second;
                second=second.next;
            }
            tail=tail.next;
        }
        tail.next=(first!=null)?first:second;
        return dummy.next;
    }}