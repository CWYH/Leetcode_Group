import java.util.*;
/**
 * 84. Largest Rectangle in Histogram -- Hard
 */

class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        Stack<Integer> stk = new Stack<>();
        int res = 0;
        int i = 0;
        while (i < heights.length) { 
            if (stk.isEmpty() || heights[stk.peek()] <= heights[i]) {
                stk.push(i);
                i++;
            } else {
                int tmp = stk.pop();
                res = Math.max(res, heights[tmp] * (stk.isEmpty() ? i : i - stk.peek() - 1));
            }
        }
        // 最后要整体合并一次
        while (!stk.isEmpty()) {
            int tmp = stk.pop();
            res = Math.max(res, heights[tmp] * (stk.isEmpty() ? heights.length : heights.length - stk.peek() - 1));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(s.largestRectangleArea(heights));
    }
}