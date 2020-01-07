/**
 * 280. Wiggle Sort -- Medium
 * 
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * Example:
 * Input: nums = [3,5,2,1,6,4]
 * Output: One possible answer is [3,5,1,6,2,4]
 */

class Solution {
    public void wiggleSort(int[] nums) {
        // if (nums.length <= 1) return;
        // Arrays.sort(nums);
        // for (int i = 1; i < nums.length - 1; i = i + 2) {
        //     int tmp = nums[i];
        //     nums[i] = nums[i + 1];
        //     nums[i + 1] = tmp;
        // }

        for (int i = 0; i < nums.length - 1; i++) {
            if ((i % 2 == 0) == (nums[i] > nums[i + 1])) {
                int tmp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = tmp;
            } 
        }
    }
}