/**
 * 366. Find Leaves of Binary Tree -- Medium
 * 
 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.
 * 
 * Example:
 * 
 * Input: [1,2,3,4,5]
 *   
 *           1
 *          / \
 *         2   3
 *        / \     
 *       4   5    
 * 
 * Output: [[4,5,3],[2],[1]]
 */ 

#include <iostream>
#include <vector>
#include <unordered_map>
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
    vector<vector<int>> findLeaves(TreeNode* root) {
        unordered_map<TreeNode*, int> h;
        h[nullptr] = 0;
        int N = getDepth(root, h);
        vector<vector<int>> res(N);
        for (auto it = h.begin(); it != h.end(); it++) {
            if (it->second > 0) {
                res[it->second - 1].push_back(it->first->val);
            }
        }
        return res;
    }

    int getDepth(TreeNode* root, unordered_map<TreeNode*, int>& h) {
        if (h.find(root) != h.end()) return h[root];
        h[root] = max(getDepth(root->left, h), getDepth(root->right, h)) + 1;
        return h[root];
    }
};
