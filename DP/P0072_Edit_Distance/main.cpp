/**
 * 第13章 动态规划
 * 13.9
 * 
 * 72. Edit Distance -- Hard
 */ 

#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int minDistance(string word1, string word2) {
        int m = word1.size();
        int n = word2.size();
        if (m == 0 && n == 0) return 0;
        if (m == 0) return n;
        if (n == 0) return m;
        vector<vector<int>> dp(m + 1, vector<int>(n + 1, 0));

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1[i - 1] == word2[j - 1]) {
                    // dp[i][j] = min(dp[i - 1][j - 1], min(dp[i - 1][j], dp[i][j - 1]) + 1);
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = min(dp[i - 1][j - 1], min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }

        return dp[m][n];
    }

    // 滚动数组
    int minDistance1(string word1, string word2) {
        int m = word1.size();
        int n = word2.size();
        if (m == 0 && n == 0) return 0;
        if (m == 0) return n;
        if (n == 0) return m;
        vector<int> dp(n + 1, 0);
        for (int i = 0; i <= n; i++) {
            dp[i] = i;
        }
        int upper_left = 0;
        for (int i = 1; i <= m; i++) {
            upper_left = dp[0];
            dp[0] = i;

            for (int j = 1; j <= n; j++) {
                int upper = dp[j];

                if (word1[i - 1] == word2[j - 1]) {
                    dp[j] = upper_left;
                } else {
                    dp[j] = min(dp[j], min(upper_left, dp[j - 1])) + 1;
                }
                upper_left = upper;
            }
        }
        return dp[n];
    }
};