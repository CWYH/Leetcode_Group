/**
 * 487. Max Consecutive Ones II -- Medium
 */

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0) return 0;
        int left = 0, right = 0;
        int lastZeroIndex = -1;

        int res = 0;
        for (; right < nums.length; right++) {
            if (nums[right] == 0) {
                left = lastZeroIndex + 1;
                lastZeroIndex = right;
            }
            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}