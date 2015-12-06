/*Invert Binary Tree
先序遍历这棵树的每个结点，若过遍历到的结点有子结点，就交换它的两个子结点。
当交换完所有的非叶子节点的左右子节点之后，就得到了树的镜像

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