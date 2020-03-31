/**
 * 485. Max Consecutive Ones -- Easy
 */

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                num++;
            } else {
                num = 0;
            }
            res = Math.max(num, res);
        }
        return res;
    }
}