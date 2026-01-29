class Solution {
    public ListNode mergeTwoLists(ListNode n1, ListNode n2) {
       ListNode dummy=new ListNode(0);
       ListNode tail=dummy;
       while(n1!=null&&n2!=null){
        if(n1.val<=n2.val){
            tail.next=n1;
            n1=n1.next;
        }else{
            tail.next=n2;
            n2=n2.next;
        }
        tail=tail.next;
       } 
       if(n1!=null){
        tail.next=n1;
       }
       if(n2!=null){
        tail.next=n2;
       }
       return dummy.next;
    }
   
}
