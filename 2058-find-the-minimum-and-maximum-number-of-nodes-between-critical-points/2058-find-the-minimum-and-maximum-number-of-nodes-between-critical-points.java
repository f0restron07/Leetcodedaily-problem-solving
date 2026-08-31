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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first=-1;
        int last=-1;
        int prevIdx=-1;
        int minD=Integer.MAX_VALUE;
        int idx=1;
        ListNode prev=head;
        ListNode cur=head.next;
        while(cur!=null&&cur.next!=null){
            int p=prev.val;
            int m=cur.val;
            int n=cur.next.val;
            if((m>p&&m>n)||(m<p&&m<n)){
                if(first==-1){
                    first=idx;
                }
                if(prevIdx!=-1){
                    minD=Math.min(minD,idx-prevIdx);
                }
                prevIdx=idx;
                last=idx;
            }
            prev=cur;
            cur=cur.next;
            idx++;
        }
        if(first==-1||first==last){
            return new int[]{-1,-1};
        }
        return new int[]{minD,last-first};
    }
}