/*Invert Binary Tree
��������������ÿ����㣬�����������Ľ�����ӽ�㣬�ͽ������������ӽ�㡣
�����������еķ�Ҷ�ӽڵ�������ӽڵ�֮�󣬾͵õ������ľ���

*/

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
    public TreeNode invertTree(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null)) return root;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        if(root.left!=null)
          invertTree(root.left);
        if(root.right!=null)
          invertTree(root.right);
        return root;
    }
}