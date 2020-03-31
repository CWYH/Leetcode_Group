/**
 * 343. Integer Break -- Medium
 */

class Solution {
    public int integerBreak(int n) {
        if (n <= 1) return 0;
        if (n == 2) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= n / 2; j++) {
                dp[i] = Math.max(dp[i], dp[j] * dp[n - j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 10;
        System.out.println(s.integerBreak(n));
    }
}