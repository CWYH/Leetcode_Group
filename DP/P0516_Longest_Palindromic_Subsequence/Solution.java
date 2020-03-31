/**
 * 516. Longest Palindromic Subsequence -- Medium
 */

class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s.length() <= 1) return s.length();
        int N = s.length();
        int dp[][] = new int[N][N];
        for (int i = N - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < N; j++) {
                if (i + 1 == j) dp[i][j] = s.charAt(i) == s.charAt(j) ? 2 : 1;
                else if (s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i + 1][j - 1] + 2;
                else dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
            }
        } 
        return dp[0][N - 1];
    }
}