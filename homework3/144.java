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
        List<Integer> res= new ArrayList<Integer>();
        Stack<TreeNode> sk = new Stack<TreeNode>();    //����ÿ�����ڵ�
        if(root==null)          //Ϊ��ֱ�ӷ���
            return res;
        TreeNode p=root;
        //sk.push(p);                   
        while(!sk.empty()||p!=null){     //������������ջΪ����pΪ��˵��������ı���
            //while(p.left!=null)
            while(p!=null){             
                sk.push(p);
                res.add(p.val);
                p=p.left;
            }
            if (!sk.empty()){       
                p = sk.peek();
                sk.pop();
                p = p.right;
            }
        }
        return res;
    }
}