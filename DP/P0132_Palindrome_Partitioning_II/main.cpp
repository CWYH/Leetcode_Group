/**
 * Chapter 13  Dynamic Programming
 * 13.3
 * 
 * 132. Palindrome Partitioning II
 */

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <climits>
using namespace std;

/**
 * dp[i] = min(dp[j + 1] + 1)  i <= j < n
 */

class Solution {
public:
    int minCut(string s) {
        int n = s.size();
        if (n <= 1) return 0;
        vector<int> dp(n + 1);
        for (int i = 0; i <= n; i++) {
            dp[i] = n - i - 1;   // dp[n] = -1
        }

        // P[i][j]??[i, j]??????
        vector<vector<bool>> P(n, vector<bool>(n, false));

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                P[i][j] = i + 2 <= j ? s[i] == s[j] && P[i + 1][j - 1] : s[i] == s[j];
                if (P[i][j]) {
                    dp[i] = min(dp[i], dp[j + 1] + 1);
                }
            }
        }
        return dp[0];
    }
};

int main() {
    Solution s;
    string str = "aabaa";
    cout << s.minCut(str) << endl;
    return 0;
}