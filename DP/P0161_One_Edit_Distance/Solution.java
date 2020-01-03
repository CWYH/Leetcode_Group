/**
 * 161. One Edit Distance -- Medium
 */

class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (s.equals(t)) return false;
        final int M = s.length();
        final int N = t.length();
        if (Math.abs(M - N) > 1) return false;
        if (M == 0 && N == 1) return true;
        if (N == 0 && M == 1) return true;

        int[][] dp = new int[M + 1][N + 1];
        for (int i = 0; i <= M; i++) dp[i][0] = i;
        for (int j = 0; j <= N; j++) dp[0][j] = j;
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
            }
        }
        return dp[M][N] == 1;
    }
} 