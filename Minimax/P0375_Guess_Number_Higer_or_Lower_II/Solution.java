/**
 * 375. Guess Number Higher or Lower II -- Meidum
 */

class Solution {
    public int getMoneyAmount(int n) {
        if (n <= 1) return 0;
        int[][] dp = new int[n + 1][n + 1];
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int m = Integer.MAX_VALUE;
                for (int k = i; k < i + len - 1; k++) {
                    m = Math.min(m, k + Math.max(dp[i][k - 1], dp[k + 1][i + len - 1]));
                }
                dp[i][i + len - 1] = m;
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 3;
        System.out.println(s.getMoneyAmount(n));
    }
}