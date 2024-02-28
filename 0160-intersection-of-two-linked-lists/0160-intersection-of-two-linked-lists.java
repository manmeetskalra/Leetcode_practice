/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp = headA;
        int c1 = 0;
        while(temp!=null){
            c1++;
            temp = temp.next;
        }
        temp = headB;
        int c2 = 0;
        while(temp!=null){
            c2++;
            temp = temp.next;
        }
        ListNode temp2;
        if(c1>c2){
            temp = headA;
            temp2 = headB;
        } else{
            temp = headB;
            temp2 = headA;
        }
        int ctr = Math.abs(c1-c2);
        while(ctr!=0){
            temp = temp.next;
            ctr--;
        }
        while(temp!=null){
            if(temp==temp2){
                return temp;
            }
            temp = temp.next;
            temp2 = temp2.next;
        }
        return null;
    }
}