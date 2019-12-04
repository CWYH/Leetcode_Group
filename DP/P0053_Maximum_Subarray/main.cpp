/**
  * Chapter 13 Dynamic Programming
  * 13.2
  *
  * 53. Maximum Subarray -- Easy
  */

#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int maxSubArray(vector<int>& nums) {
		if (nums.size() <= 0) return 0;
		int res = nums[0];
		vector<int> dp(nums.size(), 0);
		dp[0] = nums[0];
		for (int i = 1; i != nums.size(); i++) {
		    dp[i] = max(dp[i - 1] + nums[i], nums[i]);
			res = max(res, dp[i]);
		}
		return res;
    }
};
