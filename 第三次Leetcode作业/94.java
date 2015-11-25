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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<Integer>();
        if(root==null) return result;
        Stack<TreeNode> s=new Stack<TreeNode>();
        TreeNode p=root;
        while(p!=null||!s.empty()){
            if(p!=null){
                s.push(p);
                p=p.left;
            }else{
                p=s.pop();
                result.add(p.val);
                p=p.right;
            }
        }//end while
        return result;
    }
}