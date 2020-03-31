/**
 * 450. Delete Node in BST -- Medium
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

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) root.left = deleteNode(root.left, key);
        else if (key > root.val) root.right = deleteNode(root.right, key);
        else {
            if (root.left == null && root.right == null) return null;
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode x = root.left;
            TreeNode pre = x;
            while (x.right != null) {
                pre = x;
                x = x.right;
            }
            root.val = x.val;
            if (pre == x) root.left = deleteNode(x, x.val);
            else pre.right = deleteNode(pre.right, x.val);
        }
        return root;
    }

    private TreeNode getTree() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = s.getTree();
        root = s.deleteNode(root, 3);
        System.out.println(root);
    }
}