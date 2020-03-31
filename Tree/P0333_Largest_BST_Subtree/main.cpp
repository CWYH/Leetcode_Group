/**
 * 333. Largest BST Subtree -- Medium
 * 
 * Microsoft
 * 
 * Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest 
 * means subtree with largest number of nodes in it.
 * 
 * Note:
 *     A subtree must include all of its descendants.
 * 
 * Example:
 * 
 *     Input: [10,5,15,1,8,null,7]
 *        10 
 *        / \ 
 *       5*  15 
 *      / \   \ 
 *     1*   8*   7
 *     Output: 3
 *     Explanation: The Largest BST Subtree in this case is the highlighted one (*).
 *                  The return value is the subtree's size, which is 3.
 * Follow up:
 *     Can you figure out ways to solve it with O(n) time complexity?
 */

#include <iostream>
#include <algorithm>
#include <vector>
#include <unordered_map>
#include <climits>
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
    int largestBSTSubtree(TreeNode* root) {
        int ans = 0;
        DFS(root, ans);
        return ans;
    }

    // vector<int> v
    // v[0]: root子树的节点个数
    // v[1]: root子树的最小值
    // v[2]: root子树的最大值
    vector<int> DFS(TreeNode* root, int& ans) {
        if (root == nullptr) return vector<int>{0, INT_MAX, INT_MIN};
        vector<int> left = DFS(root->left, ans);
        vector<int> right = DFS(root->right, ans);
        if (root->val > left[2] && root->val < right[1]) {
            int min_value = min(left[1], root->val);
            int max_value = max(right[2], root->val);
            ans = max(ans, left[0] + right[0] + 1);
            return vector<int>({left[0] + right[0] + 1, min_value, max_value});
        }

        return vector<int>{0, INT_MIN, INT_MAX};
    }
};