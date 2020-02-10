/**
 * 486. Predict the Winner -- Medium
 */

class Solution {
    // public boolean PredictTheWinner(int[] nums) {
    //     if (nums.length <= 2) return true;
    //     return DFS(nums, 0, nums.length - 1, 0, 0);
    // }

    // private boolean DFS(int[] nums, int lo, int hi, int player, int diff) {
    //     if (lo > hi) {
    //         return player == 0 ? diff >= 0 : diff < 0;
    //     }

    //     if (player == 0) {
    //         if (!DFS(nums, lo + 1, hi, 1, diff + nums[lo]) || !DFS(nums, lo, hi - 1, 1, diff + nums[hi])) {
    //             return true;
    //         }
    //         return false;
    //     } else {
    //         if (!DFS(nums, lo + 1, hi, 0, diff - nums[lo]) || !DFS(nums, lo, hi - 1, 0, diff - nums[hi])) {
    //             return true;
    //         }
    //         return false;
    //     }
    // }

    public boolean PredictTheWinner(int[] nums) {
        if (nums.length <= 2) return true;
        final int N = nums.length;
        int[][] dp = new int[N][N];
        for (int i = N - 1; i >= 0; i--) {
            dp[i][i] = nums[i];
            for (int j = i + 1; j < N; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][N - 1] >= 0;
    }

    

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 5, 233, 2, 9, 76, 65, 4, 9876, 76, 65, 41, 7};
        System.out.println(s.PredictTheWinner(nums));
    }
}