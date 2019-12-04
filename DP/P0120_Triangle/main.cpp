/**
 * Chapter 13  Dynamic Programming
 * 13.1
 * 
 * 120. Triangle -- Medium
 */ 

#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
using namespace std;

class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
		int N = triangle.size();
		if (N <= 0) return 0;
        // vector<vector<int>> dp(N);
		// for (int i = 0; i < N; i++) {
		// 	dp[i].resize(i + 1);
		// }
		
		// dp[0][0] = triangle[0][0];
		// for (int i = 1; i < N; i++) {
		// 	for (int j = 0; j <= i; j++) {
		// 		if (j == 0) {
		// 			dp[i][j] = dp[i - 1][j] + triangle[i][j];
		// 		} else if (j == i) {
		// 			dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
		// 		} else {
		// 			dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
		// 		}
		// 	}
		// }
		
		// int res = INT_MAX;
		// for (int i = 0; i < N; i++) {
		// 	res = min(res, dp[N - 1][i]);
		// }

		vector<int> dp(N, 0);
		dp[0] = triangle[0][0];
		for (int i = 1; i < N; i++) {
			for (int j = i; j >= 0; j--) {
				if (j == i) {
					dp[j] = dp[j - 1] + triangle[i][j];
				} else if (j == 0) {
					dp[j] = dp[j] + triangle[i][j];
				} else {
					dp[j] = min(dp[j], dp[j - 1]) + triangle[i][j];
				}
			}
		}

		int res = INT_MAX;
        for  (int i = 0; i < N; i++){
            res = min(res, dp[i]);
        }
	
		return res;
    }
};
