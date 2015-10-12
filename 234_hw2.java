/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
    if(head == null || head.next == null)         //一个元素或者空直接返回真
        return true;
    ListNode Mid=head;
	ListNode a=head;
    while(Mid.next!=null &&Mid.next.next!=null){        //找到head的中间节点
		Mid=Mid.next.next;
		a=a.next;
	}
	Mid=a.next;
    if(Mid==null||Mid.next==null)                      
	{
	    if(Mid.val==head.val)                 //   有两个元素，如果元素值相等，则返回真，否则返回假 
			return true;
		else
			return false;
	}
	else
	{
        ListNode pre = Mid;                   //从中间节点开始到尾节点结束逆序放置
        ListNode cur = pre.next;
        pre.next = null;   
        ListNode post = null;
            while(cur!=null)
            {
                post = cur.next;
                cur.next = pre;
                pre = cur;
                cur = post;
            }
        Mid=pre; 
	}
    while(head!=null && Mid!=null)         //将逆序放置的链表和正序链表比较，如果有不等则返回假，否则返回真
    {  
        if(head.val != Mid.val) return false;  
        head = head.next;  
        Mid = Mid.next;  
    }  
    return true;
            
        
    }  
}  