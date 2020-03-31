/**
 * 513. Find Bottom Left Tree Value -- Medium
 */

#include <iostream>
#include <algorithm>
using namespace std;

/**
 * Definition for a binary tree node.
 */
struct TreeNode {
	int val;
	TreeNode* left;
	TreeNode* right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
	int findBottomLeftValue(TreeNode* root) {
		int level = 0;
		return findBottomLeftValue(root, level);
	}

	int findBottomLeftValue(TreeNode* root, int& level) {
		if (root->left == nullptr && root->right == nullptr) {
			level++;
			return root->val;
		}
		int left_level = level;
		int right_level = level;
		int left_val = 0, right_val = 0;
		if (root->left != nullptr) {
			left_level++;
			left_val = findBottomLeftValue(root->left, left_level);
		}
		if (root->right != nullptr) {
			right_level++;
			right_val = findBottomLeftValue(root->right, right_level);
		}

		level = max(left_level, right_level);
		if (left_level >= right_level) {
			return left_val;
		}
		else {
			return right_val;
		}
	}
};

int main() {
	Solution s;
	TreeNode* root = new TreeNode(1);
	root->left = new TreeNode(2);
	root->right = new TreeNode(3);
	root->left->left = new TreeNode(4);
	root->right->left = new TreeNode(5);
	root->right->right = new TreeNode(6);
	root->right->left->left = new TreeNode(7);

	// printf("%d\n", s.findBottomLeftValue(root));
	// printf("%d\n", s.findBottomLeftValue(root->left));
	printf("%d\n", s.findBottomLeftValue(root->right));
	return 0;
}