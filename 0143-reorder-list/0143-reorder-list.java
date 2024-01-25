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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        slow.next = null;
        // ListNode prev = null;
        // while (second != null) {
        //     ListNode tmp = second.next;
        //     second.next = prev;
        //     prev = second;
        //     second = tmp;
        // }
        second = reverse(second);
        ListNode first = head;
        while(second!=null){
            ListNode t1 = first.next;
            ListNode t2 = second.next;
            first.next = second;
            second.next = t1;
            first = t1;
            second = t2;
        }
    }
    public ListNode reverse(ListNode root){
        ListNode prev = null;
        while(root!=null){
            ListNode t = root.next;
            root.next = prev;
            prev = root;
            root = t;
        }
        return prev;
    }
}