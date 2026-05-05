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
class Solution{
    public ListNode rotateRight(ListNode a,int b){
        if(a==null||a.next==null||b==0){
            return a;
        }
        int c=1;
        ListNode d=a;
        while(d.next!=null){
            d=d.next;
            c++;
        }
        d.next=a;
        b=b%c;
        int e=c-b;
        ListNode f=a;
        for(int g=1;g<e;g++){
            f=f.next;
        }
        ListNode h=f.next;
        f.next=null;
        return h;
    }
}