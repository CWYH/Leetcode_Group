/**
 * 145. Binary Tree Postorder Traversal -- Hard
 */ 

//
// 后序遍历--即从右向左先序遍历的逆序
//

#include <iostream>
#include <vector>
#include <stack>
using namespace std;

/**
 * Definition for a binary tree node.
 */
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
 
class Solution {
public:
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> res;
        if (root == nullptr) return res;

        stack<TreeNode*> stk;
        TreeNode* x = root;
        while (x != nullptr || !stk.empty()) {
            if (x != nullptr) {
                res.insert(res.begin(), x->val);
                stk.push(x);
                x = x->right;
            } else {
                x = stk.top();
                stk.pop();
                x = x->left;
            }
        }

        return res;
    }
};