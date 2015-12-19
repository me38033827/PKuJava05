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
    
    
    public boolean isSymmetric(TreeNode left, TreeNode right)  //�ж����������Ƿ�Գƣ��������������Ƿ�����������Һ��ӶԳƣ����������Һ����Ƿ�������������ӶԳƣ�
        {
        if (left == null && right == null)
             return true;
        if(left!=null && right!=null && left.val == right.val)  
            return isSymmetric(left.right,right.left) && isSymmetric(left.left, right.right);  
        else return false;  
        }
    
    public boolean isSymmetric(TreeNode root) {
        if(root==null||root.left==root.right)
        {
            return true;
        }
        return isSymmetric(root.left,root.right);
    }
}