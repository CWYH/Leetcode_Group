/**
 * 99. Recover Binary Search Tree -- Hard
 */ 

#include <iostream>
#include <algorithm>
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
    void recoverTree(TreeNode* root) {
        TreeNode* pre = nullptr;
        TreeNode* firstNode = nullptr;
        TreeNode* secondNode = nullptr;
        inOrder(root, pre, firstNode, secondNode);
        swap(firstNode->val, secondNode->val);
    }

private:
    void inOrder(TreeNode* root, TreeNode* pre, TreeNode* firstNode, TreeNode* secondNode) {
        if (root == nullptr) return;
        inOrder(root->left, pre, firstNode, secondNode);
        if (pre != nullptr && pre->val > root->val) {
            firstNode = pre;
            secondNode = root;
        } else {
            secondNode = root;
        }
        pre = root;
        inOrder(root->right, pre, firstNode, secondNode);
    }
};