/**
 * 41. First Missing Positive -- Hard
 */

class Solution {
    public int firstMissingPositive(int[] nums) {
        final int N = nums.length;
        if (N == 0) return 1;

        for (int i = 0; i < N; i++) {
            while (nums[i] > 0 && nums[i] <= N && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int i = 0; i < N; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return N + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}