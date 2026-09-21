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
        ListNode mid=middleNode(head);
        
        ListNode right=mid.next;
        mid.next=null;
        ListNode left=sortList(head);
        right=sortList(right);
        return mergeTwoLists(left,right);
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while (list1 != null && list2 != null){
            if(list1.val==list2.val){
                temp.next=list1;
                temp=temp.next;
                list1=list1.next;
                temp.next=list2;
                temp=temp.next;
                list2=list2.next;
            }else
            if(list1.val<list2.val){
                temp.next=list1;
                temp=temp.next;
                list1 = list1.next;
            }else{
                temp.next=list2;
                temp=temp.next;
                list2 = list2.next;
            }

        }

        if(list1!=null){
            temp.next=list1;
        }else{
            temp.next = list2;
        }

        return dummy.next;
    }


    public ListNode middleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}