/*
Symmetric Tree
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree is symmetric: 
    1
   / \
  2   2
 / \ / \
3  4 4  3
 

But the following is not:
 
    1
   / \
  2   2
   \   \
   3    3


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
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return mySymmetric(root.left,root.right);
    }
    
    public boolean mySymmetric(TreeNode left_node, TreeNode right_node) {  
        if (left_node != null && right_node != null && left_node.val == right_node.val)  
            return mySymmetric(left_node.left, right_node.right) &&  
                   mySymmetric(left_node.right, right_node.left);  
        else if (left_node == null && right_node == null)  
            return true;  
        else   
           return false;  
    } 

}