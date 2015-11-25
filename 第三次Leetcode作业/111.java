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
        if(root==null) return 0;
        else if(root.left==null) return minDepth(root.right)+1;
        else if(root.right==null) return minDepth(root.left)+1;
        else {
        int leftlen=minDepth(root.left);
        int rightlen=minDepth(root.right);
        return leftlen<rightlen?leftlen+1:rightlen+1;
        }
    }
}