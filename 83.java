/*
Remove Duplicates from Sorted List
 
Given a sorted linked list, delete all duplicates such that each element appear only once.
 
For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3. 



Subscribe to see which companies asked this question
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        ListNode result=new ListNode(head.val);
        ListNode cur=result;
        ListNode p=head.next;
        while(p!=null){
            if(p.val!=cur.val){
                cur.next=new ListNode(p.val);
                cur=cur.next;
            }
            p=p.next;
        }
       return result; 
    }
}