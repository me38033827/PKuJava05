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
        TreeNode[] queue=new TreeNode[100000];    //数组大小1000的话不能满足测试的需求
        int font=0,rear=1;            //font和rear分别表示队列的头和尾
        queue[font]=root;
        if(queue[font]==null)
            return 0;
    //    queue[font].val=0;
        queue[font].val=1;          //根节点的深度为1，val用来保存每个节点的层数
        while(queue[font]!=null){
            if(queue[font].left!=null){      //左子树入队列
                queue[rear]=queue[font].left;
                queue[rear].val=queue[font].val+1;
                rear++;
            }
            if(queue[font].right!=null)      //右子树入队列
            {
                queue[rear]=queue[font].right;
                queue[rear].val=queue[font].val+1;
                rear++;
            }
            if(queue[font].left==null && queue[font].right==null){     //左右子树都为空，找到叶子节点，返回层数
                return queue[font].val;
            }else{
                font++;
            }
            
        }
        return queue[font].val; 
        
    }
}