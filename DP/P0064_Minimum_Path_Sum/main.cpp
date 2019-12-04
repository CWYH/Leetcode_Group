/**
 * 第13章 动态规划
 * 13.8
 * 64. Minimum Path Sum -- Medium
 */

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

class Solution {
public:
	int minPathSum(vector<vector<int>>& grid) {
		int m = grid.size();
		if (m == 0) return 0;
		int n = grid[0].size();
		if (n == 0) return 0;

		vector<vector<int>> dp(m, vector<int>(n, 0));
		for (int i = 0; i != m; i++) {
			for (int j = 0; j != n; j++) {
				if (i == 0 && j == 0) dp[i][j] = grid[i][j];
				else if (i > 0 && j == 0) dp[i][j] = dp[i - 1][j] + grid[i][j];
				else if (i == 0 && j > 0) dp[i][j] = dp[i][j - 1] + grid[i][j];
				else dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
			}
		}

		return dp[m - 1][n - 1];
	}
};

int main() {
	Solution s;
	vector<vector<int>> grid = {
		{1, 3, 1},
	    {1, 5, 1},
	    {4, 2, 1}
	};
	cout << s.minPathSum(grid) << endl;
    return 0;
}