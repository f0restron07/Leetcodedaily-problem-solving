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
    public int getDecimalValue(ListNode head) {
        ListNode temp=head;
        String t="";
        while(temp!=null){
            int tmp=temp.val;
            t=t+Integer.toString(tmp);
            temp=temp.next;
        }
        int decimal = Integer.parseInt(t, 2); 
        return decimal;
    }
}