/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int minDepth(TreeNode root) {
        TreeNode[] queue=new TreeNode[100000];    //�����С1000�Ļ�����������Ե�����
        int font=0,rear=1;            //font��rear�ֱ��ʾ���е�ͷ��β
        queue[font]=root;
        if(queue[font]==null)
            return 0;
    //    queue[font].val=0;
        queue[font].val=1;          //���ڵ�����Ϊ1��val��������ÿ���ڵ�Ĳ���
        while(queue[font]!=null){
            if(queue[font].left!=null){      //�����������
                queue[rear]=queue[font].left;
                queue[rear].val=queue[font].val+1;
                rear++;
            }
            if(queue[font].right!=null)      //�����������
            {
                queue[rear]=queue[font].right;
                queue[rear].val=queue[font].val+1;
                rear++;
            }
            if(queue[font].left==null && queue[font].right==null){     //����������Ϊ�գ��ҵ�Ҷ�ӽڵ㣬���ز���
                return queue[font].val;
            }else{
                font++;
            }
            
        }
        return queue[font].val; 
        
    }
}