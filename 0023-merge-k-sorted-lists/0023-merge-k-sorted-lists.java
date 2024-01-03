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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode l1 = null;
        for(int i=0;i<lists.length;i++){
            if(l1==null){
                l1 = lists[i];
            }else{
                ListNode temp = mergeTwoLists(l1,lists[i]);
                l1 = temp;
            }
        }
        return l1;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode res = new ListNode(-1);
        ListNode temp = res;
        while(l1!=null || l2!=null){
            if(l1==null){
                temp.next = l2;
                break;
            }else if(l2==null){
                temp.next = l1;
                break;
            }else{
                if(l1.val<l2.val){
                    temp.next = l1;
                    l1 = l1.next;
                }else{
                    temp.next = l2;
                    l2 = l2.next;
                }
                temp = temp.next;
            }
        }
        return res.next;
    }
}