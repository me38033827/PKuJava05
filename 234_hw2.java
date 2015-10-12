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
    if(head == null || head.next == null)         //һ��Ԫ�ػ��߿�ֱ�ӷ�����
        return true;
    ListNode Mid=head;
	ListNode a=head;
    while(Mid.next!=null &&Mid.next.next!=null){        //�ҵ�head���м�ڵ�
		Mid=Mid.next.next;
		a=a.next;
	}
	Mid=a.next;
    if(Mid==null||Mid.next==null)                      
	{
	    if(Mid.val==head.val)                 //   ������Ԫ�أ����Ԫ��ֵ��ȣ��򷵻��棬���򷵻ؼ� 
			return true;
		else
			return false;
	}
	else
	{
        ListNode pre = Mid;                   //���м�ڵ㿪ʼ��β�ڵ�����������
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
    while(head!=null && Mid!=null)         //��������õ��������������Ƚϣ�����в����򷵻ؼ٣����򷵻���
    {  
        if(head.val != Mid.val) return false;  
        head = head.next;  
        Mid = Mid.next;  
    }  
    return true;
            
        
    }  
}  