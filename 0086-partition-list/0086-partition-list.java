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
    public ListNode partition(ListNode head, int x) {
        ListNode temp=head;
        ListNode dummy=new ListNode(-1);//<x
        ListNode dummy2=new ListNode(-1);//>=x
        ListNode temp1=dummy;
        ListNode temp2=dummy2;
        while(temp!=null){
            if(temp.val<x){
                temp1.next=temp;
                temp1=temp;
            }else{
                temp2.next=temp;
                temp2=temp;
            }
            temp=temp.next;
        }
        temp2.next=null;
        temp1.next=dummy2.next;
        return dummy.next;
    }
}