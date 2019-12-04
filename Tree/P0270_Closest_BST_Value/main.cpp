/**
 * 270. Closest Binary Search Tree Value -- Easy
 * 
 * Microsoft
 * 
 * Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
 * Note:
 *     * Given target value is a floating point.
 *     * You are guaranteed to have only one unique value in the BST that is closest to the target.
 * Example:
 *     Input: root = [4,2,5,1,3], target = 3.714286
 *     
 *         4
 *        / \
 *       2   5
 *      / \
 *     1   3
 *     
 *     Output: 4
 *
 */

#include <iostream>
#include <cmath>
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
    int closestValue(TreeNode* root, double target) {
        if (root->left == nullptr && root->right == nullptr) return root->val;
        int tmp = root->val;
        if (target <= root->val && root->left != nullptr) 
            tmp = closestValue(root->left, target);
        else if (target > root->val && root->right != nullptr)
            tmp = closestValue(root->right, target);

        return abs(tmp - target) < abs(root->val - target) ? tmp : root->val;
    }
};