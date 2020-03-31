/**
 * 255. Verify Preorder Sequence in Binary Search Tree -- Medium
 * 
 * 单调栈
 */

class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stk = new Stack<>();
        int MIN = Integer.MIN_VALUE;
        for (int i = 0; i < preorder.length; i++) {
            if (preorder[i] < MIN) {
                return false;
            }

            while (!stk.isEmpty() && stk.peek() < preorder[i]) {
                MIN = stk.pop();
            }

            stk.push(preorder[i]);
        }

        return true;
    }
} 