/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int minDepth(TreeNode* root) {
        if(root==NULL) return 0;
        vector<int> prev;
        vector<vector<int>> result;
        TreeNode *node;
        queue<TreeNode*> q;
        q.push(root);
        int level=1;
        while(!q.empty()){
            int size=q.size();
            prev.clear();
            while(size--){
                node=q.front();
                prev.push_back(node->val);
                q.pop();
                if(node->left==NULL&&node->right==NULL) return level;
                if(node->left!=NULL)
                   q.push(node->left);
                if(node->right!=NULL)
                   q.push(node->right);
            }
            level++;
            result.push_back(prev);  
        }
        return level;
    }
};




/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int maxDepth(TreeNode* root) {
        if(root==NULL) return 0;
        //vector<int> prev;
        //vector<vector<int>> result;
        TreeNode *node;
        queue<TreeNode*> q;
        q.push(root);
        int level=0;
        while(!q.empty()){
            int size=q.size();
            //prev.clear();
            while(size--){
                node=q.front();
                //prev.push_back(node->val);
                q.pop();
                //if(node->left==NULL&&node->right==NULL) return level;
                if(node->left!=NULL)
                   q.push(node->left);
                if(node->right!=NULL)
                   q.push(node->right);
            }
            level++;
            //result.push_back(prev);  
        }
        return level;
    }
};