import java.util.LinkedList;
import java.util.List;

/**
 * 368. Largest Divisible Subset -- Medium
 */

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        final int N = nums.length;
        List<Integer> res = new LinkedList<>();
        if (N == 0) return res;
        if (N == 1) {
            res.add(nums[0]);
            return res;
        }

        Arrays.sort(nums);

        int[] dp = new int[N];    // 以nums[i]结尾的序列最大长度
        int[] last = new int[N];  // 在最大序列中 nums[i]的上一个元素在nums出现的下标
        Arrays.fill(dp, 1);
        Arrays.fill(last, -1);

        int end = 0;
        int maxSize = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                    last[i] = j;
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                end = i;
            }
        }
        for (int i = end; i >= 0; i = last[i]) {
            res.add(0, nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2, 3};
        List<Integer> res = s.largestDivisibleSubset(nums);
        for (Integer e : res) {
            System.out.println(e);
        }
    }
}