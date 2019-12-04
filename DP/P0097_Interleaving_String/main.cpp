/**
 * 97. Interleaving String -- Hard
 */ 

#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
        const int m = s1.size();
        const int n = s2.size();
        if (m + n != s3.size()) return false;
        vector<vector<bool>> dp(m + 1, vector<bool>(n + 1, false));
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) dp[i][j] = true;
                else if (i == 0 && j != 0) dp[i][j] = dp[i][j - 1] && s2[j - 1] == s3[i + j - 1];
                else if (i != 0 && j == 0) dp[i][j] = dp[i - 1][j] && s1[i - 1] == s3[i + j - 1];
                else dp[i][j] = (dp[i][j - 1] && s2[j - 1] == s3[i + j - 1]) || (dp[i - 1][j] && s1[i - 1] == s3[i + j - 1]);
            }
        }

        return dp[m][n];
    }
};