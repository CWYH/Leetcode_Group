/**
 * 287. Find the Duplicate Number -- Medium
 */


class Solution {
    public int findDuplicate(int[] nums) {
        final int n = nums.length - 1;
        for (int i = 0; i <= n; i++) {
            if (nums[i] == i + 1) continue;
            while (nums[i] != i + 1) {
                if (nums[i] == nums[nums[i] - 1]) return nums[i];
                int tmp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[tmp - 1] = tmp;
            }
        }
        return nums[0];
    }
}