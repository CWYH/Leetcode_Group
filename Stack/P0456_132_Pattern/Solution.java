import java.util.Stack;
/**
 * 456. 132 Pattern -- Medium
 */

class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(nums[i], min[i - 1]);
        }

        Stack<Integer> stk = new Stack<>();
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] > min[j]) {
                while (!stk.isEmpty() && stk.peek() <= min[j]) {
                    stk.pop();
                }
                if (!stk.isEmpty() && stk.peek() < nums[j]) {
                    return true;
                }
                stk.push(nums[j]);
            }
        }
        return false;
    }
}