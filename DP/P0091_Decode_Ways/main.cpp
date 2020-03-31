/***
 * 第13章 动态规划
 * 13.10 
 * 
 * 91. Decode Ways -- Medium
 */

#include <iostream>
#include <string>
#include <vector>
using namespace std;

/**
Test Case: 1206 -- 1
*/ 

class Solution {
public:
    int numDecodings(string s) {
        int n = s.size();
        if (n <= 0) return 0;
        vector<int> dp(n, 0);
        if (s[0] == '0') return 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int num = (s[i - 1] - '0') * 10 + s[i] - '0';
            if (s[i] == '0') {
                if (num <= 0 || num > 26) return 0;
                else {
                    dp[i] = i >= 2 ? dp[i - 2] : 1;
                }
            } else {
                if (num <= 0 || num > 26) dp[i] = dp[i - 1];
                else {
                    if (s[i - 1] == '0') dp[i] = dp[i - 1];
                    else dp[i] = i >= 2 ? dp[i - 2] + dp[i - 1] : dp[i - 1] + 1;
                }
            }
        }
        return dp[n - 1];
    }
};