/**
 * 300. Longest Increasing Subsequence -- Medium
 */ 

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        const int N = nums.size();
        if (N <= 0) return 0;
        if (N == 1) return 1;

        vector<int> dp(N, 1);
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 1;
        for (int i = 0; i < N; i++) {
            res = max(res, dp[i]);
        }

        return res;
    }

    // DP with Binary Search
    
};