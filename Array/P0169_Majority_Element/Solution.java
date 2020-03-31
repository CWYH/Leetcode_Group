/**
 * 169. Majority Element -- Easy
 */

class Solution {
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int n = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == res) n++;
            else n--;
            if (n == 0) {
                res = nums[i];
                n = 1;
            }
        }
        return res;
    }
}