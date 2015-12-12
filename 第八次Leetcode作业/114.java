/*
Flatten Binary Tree to Linked List
 Given a binary tree, flatten it to a linked list in-place. 

For example,
 Given 
         1
        / \
       2   5
      / \   \
     3   4   6
 
The flattened tree should look like:
    1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6

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
    public void flatten(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null)) return;
        Stack<TreeNode> s=new Stack<TreeNode>();
        TreeNode p=root;
        TreeNode cur=root;
        s.push(p);
        while(!s.empty()){
             p=s.pop();
             if(p!=root){
                 cur.right=p;
                 cur.left=null;
                 cur=cur.right;
             }
             if(p.right!=null) s.push(p.right);
             if(p.left!=null) s.push(p.left);
         }
    }
}