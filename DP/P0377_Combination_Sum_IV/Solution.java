/**
 * 377. Combination Sum IV -- Medium
 */

class Solution {
    public int combinationSum4(int[] nums, int target) {
        final int N = nums.length;
		Arrays.sort(nums);
		if (N <= 0 || target < nums[0]) return 0;
		if (target == nums[0]) return 1;
		
		int[] dp = new int[target + 1];
		dp[nums[0]] = 1;
		for (int n = nums[0] + 1; n <= target; n++) {
			for (int k = 0; k < N; k++) {
				if (n == nums[k]) {
					dp[n]++;
				} else if (n > nums[k] && n <= nums[0] + nums[k]) {
					dp[n] += dp[n - nums[k]];
				}
			}
		}
		
		return dp[target];
    }
}