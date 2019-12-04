/**
 * 404. Sum of Left Leaves -- Easy
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
    
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 0;
        int L = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            L = root.left.val;
        } else {
            L = sumOfLeftLeaves(root.left);
        }
        int R = sumOfLeftLeaves(root.right);
        return L + R;
    }
}