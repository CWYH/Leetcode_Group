import java.util.*;

/**
 * 325. Maximum Size Subarray Sum Equals K -- Medium
 */

 /**
  * HashMap, key为当前前缀和，val为第一次出现该前缀和的下标
  */
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        final int N = nums.length;
        if (N == 0) return 0;
        HashMap<Integer, Integer> h = new HashMap<>();
        h.put(0, -1);
        int sum = 0;
        int res = 0;
        for (int i = 0; i < N; i++) {
            sum += nums[i];
            int key = sum - k;
            if (h.containsKey(key)) {
                res = Math.max(res, i - h.get(key));
            }

            if (!h.containsKey(sum)) { // 如果hashmap中已经有了前缀和sum，则不再添加
                h.put(sum, i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {-5,8,2,-1,6,-3,7,1,8,-2,7};
        int k = -4;
        System.out.println(s.maxSubArrayLen(nums, k));
    } 
}