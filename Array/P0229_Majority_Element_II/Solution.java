import java.util.*;

/**
 * 229. Majority Element II -- Medium
 */

// Bayor-Moore Majority Vote Algorithm

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cnt1 = 0, cnt2 = 0;
        int candidate1 = 0, candidate2 = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate1) {
                cnt1++;
            } else if (nums[i] == candidate2) {
                cnt2++;
            } else if (cnt1 == 0) {
                candidate1 = nums[i];
                cnt1 = 1;
            } else if (cnt2 == 0) {
                candidate2 = nums[i];
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        List<Integer> res = new ArrayList<>();
        if (isMajority(nums, candidate1)) res.add(candidate1);
        if (isMajority(nums, candidate2)) res.add(candidate2);
        return res;
    }

    private boolean isMajority(int[] nums, int candidate) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate) cnt++;
        }
        return cnt > nums.length / 3;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,1,1,3,3,2,2,2};
        List<Integer> res = s.majorityElement(nums);
        for (Integer e : res) {
            System.out.println(e);
        }
    }
}