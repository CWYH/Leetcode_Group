/**
 * 222. Count Complete Tree Nodes
 */

class Solution {
    /**
     * Definition for a binary tree node.
     */ 
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null) return 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}