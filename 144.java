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
    public List<Integer> preorderTraversal(TreeNode root) {
         List<Integer> result=new ArrayList<Integer>();
         if(root==null) return result;
         Stack<TreeNode> s=new Stack<TreeNode>();
         TreeNode p=root;
         s.push(p);
         while(!s.empty()){
             p=s.pop();
             result.add(p.val);
             if(p.right!=null) s.push(p.right);
             if(p.left!=null) s.push(p.left);
         }
        return result;
    }
}