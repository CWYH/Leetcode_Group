import java.util.*;
/**
 * 673. Number of Longest Increasing Subsequence -- Medium
 */

class Solution {
    public int findNumberOfLIS(int[] nums) {
        final int N = nums.length;
        if (N <= 0) return 0;
        if (N == 1) return 1;

        int[] dp = new int[N];
        int[] amount = new int[N];
        Arrays.fill(dp, 1);
        Arrays.fill(amount, 1);
        int maxLen = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        amount[i] = amount[j];
                        dp[i] = dp[j] + 1;
                    } else if (dp[j] + 1 == dp[i]) {
                        amount[i] += amount[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            if (dp[i] == maxLen) {
                res += amount[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 3, 2};
        System.out.println(s.findNumberOfLIS(nums));
    }
}