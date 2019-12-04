/**
 * 209. Minimum Size Subarray Sum -- Medium
 */

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length <= 0) return 0;
        int i = 0;
        int j = 0;
        int res = nums.length + 1;
        int sum = nums[0];
        while (i < nums.length && j < nums.length) {
            if (sum >= s) {
                if (i == j) return 1;
                else {
                    res = Math.min(res, j - i + 1);
                    sum -= nums[i];
                    i++;
                }
            } else {
                j++;
                if (j < nums.length) sum += nums[j];
            }
        }
        if (res == nums.length + 1) res = 0;
        return res;
    }
}