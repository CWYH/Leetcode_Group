import java.util.Stack;

/**
 * 99. Recover Binary Search Tree -- Hard
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
 

    public void recoverTree(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        inOrder(root, arr);
        Collections.sort(arr);
        
        Stack<TreeNode> stk = new Stack<>();
        TreeNode x = root;
        int idx = 0;
        while (!stk.isEmpty() && x != null) {
            if (x != null) {
                stk.push(x);
                x = x.left;
            } else {
                x = stk.pop();
                if (x.val != arr.get(idx)) {
                    x.val = arr.get(idx);
                } 
                idx++;
                x = x.right;
            }
        }
    }

    private void inOrder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) return;
        inOrder(root.left, arr);
        arr.add(root.val);
        inOrder(root.right, arr);
    }

    
}