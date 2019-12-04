/**
 * 174. Dungeon Game -- Hard
 */

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int calculateMinimumHP(vector<vector<int>>& dungeon) {
        const int m = dungeon.size();
        const int n = dungeon[0].size();
        vector<vector<int>> dp(m, vector<int>(n, 0));
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) dp[m - 1][n - 1] = 1 - dungeon[m - 1][n - 1];
                else if (i == m - 1 && j < n - 1) dp[i][j] = dp[i][j + 1] - dungeon[i][j];
                else if (i < m - 1 && j == n - 1) dp[i][j] = dp[i + 1][j] - dungeon[i][j];
                else dp[i][j] = min(dp[i][j + 1], dp[i + 1][j]) - dungeon[i][j];

                if (dp[i][j] <= 0) dp[i][j] = 1;    // Attention: make sure that dp[i][j] > 0
            }
        }

        return dp[0][0];
    }
};