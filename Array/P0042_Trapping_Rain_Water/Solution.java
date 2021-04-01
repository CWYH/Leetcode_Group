/**
 * 42. Trapping Rain Water -- Hard
 */

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        for (int i = 1; i < n - 1; i++) {
            maxLeft[i] = Math.max(height[i - 1], maxLeft[i - 1]);
            maxRight[n - 1 - i] = Math.max(height[n - i], maxRight[n - i]);
        }

        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            int h = Math.min(maxLeft[i], maxRight[i]);
            if (h > height[i]) {
                res += h - height[i];
            }
        }

        return res;
    }
}