Given a linked list, determine if it has a cycle in it. 

Follow up:
 Can you solve it without using extra space? 



Subscribe to see which companies asked this question

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null) return false;
        ListNode slow=head;
        ListNode fast=head;
        do{
            if(slow==null||fast==null) return false;
            slow=slow.next;
            fast=fast.next;
            if(fast!=null)
               fast=fast.next;
            else
               return false;
        }while(slow!=fast);
        return true;
    }
}