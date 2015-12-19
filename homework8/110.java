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
    public int depth(TreeNode root){  
        if(root==null){  
            return 0;  
        }  
        return 1+Math.max(depth(root.left), depth(root.right));  
    }  
    public boolean isBalanced(TreeNode root) {
        /*if(root==null)
           return true;
        if(root!=null&&root.left==null&&root.right!=null){
            if(root.right.left!=null||root.right.right!=null)
                return false;
        }
        else if(root!=null&&root.left!=null&&root.right==null){
            if(root.left.left!=null||root.left.right!=null)
                return false;
        }else if(root!=null&&root.left!=null&&root.right!=null){
                //return isBalanced(root.left)&&isBalanced(root.right);
            if(root.left.left==null&&root.left.right==null&&root.right.left!=null)
                return false;
            if(root.left.left==null&&root.left.right==null&&root.right.right!=null)
                return false;
            if(root.right.left==null&&root.right.right==null&&root.left.right!=null)
                return false;
            if(root.right.left==null&&root.right.right==null&&root.left.left!=null)
                return false;  
        }
        return isBalanced(root.left)&&isBalanced(root.right);*/
        if(root == null){             //只能通过层数的差来判断，如果左右子树差值超过1则返回否则对左右子树分别进行判断
            return true;  
        }  
        if(Math.abs(depth(root.left)-depth(root.right)) > 1){  
            return false;  
        }  
        return isBalanced(root.left) && isBalanced(root.right);  
        
    }
}