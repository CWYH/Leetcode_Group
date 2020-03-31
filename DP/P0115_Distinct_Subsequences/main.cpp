/**
 * 第13章 动态规划
 * 13.11
 * 
 * 115. Distinct Subsequences -- Head
 */ 

#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int numDistinct(string s, string t) {
        int m = s.size(), n = t.size();
        if (m <= 0 || n <= 0) return 0;
        vector<vector<long long>> dp(m + 1, vector<long long>(n + 1, 0));
        for (int i = 0; i <= m; i++) { 
            dp[i][0] = 1;   // t[0:0]为空串
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s[i - 1] != t[j - 1]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }
};

