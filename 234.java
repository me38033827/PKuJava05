//Palindrome Linked List

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /*O(n),O(n)
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null) return true;
        Stack<Integer> s=new Stack<Integer>();  
        ListNode p=head;
        while(p!=null){
            s.push(p.val);
            p=p.next;
        }
        while(head!=null){
            if(head.val!=s.pop()) return false;
            head=head.next;
        }
        return true;
    }*/
    
//O(n),O(1) 栈的实质是递归
    public
    ListNode p;
    boolean judge(ListNode head)
    {
        if(head==null) return true;

        if(judge(head.next) == false) return false;

        if(p.val != head.val) return false;
        else{
            p= p.next;
            return true;
        }
    }
    boolean isPalindrome(ListNode head) {
        if(head ==null || head.next == null) return true;
        p=head;
        return judge(head);
    }
}