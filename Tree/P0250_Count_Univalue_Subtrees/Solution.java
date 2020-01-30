/**
 * 250. Count Univalue Subtrees -- Medium
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

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int cntLeft = countUnivalSubtrees(root.left);
        int cntRight = countUnivalSubtrees(root.right);
        int cntRoot = isUnivalSubtrees(root) ? 1 : 0;
        return cntLeft + cntRight + cntRoot;
    }

    private boolean isUnivalSubtrees(TreeNode root) {
        if (root == null) return true;
        if (root.left != null && root.left.val != root.val) return false;
        if (root.right != null && root.right.val != root.val) return false;
        return isUnivalSubtrees(root.left) && isUnivalSubtrees(root.right);
    }
}