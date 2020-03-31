import java.util.HashMap;

/**
 * 560. Subarray Sum Equals K -- Medium
 */

class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0) return 0;

        final int N = nums.length;
        int[] S = new int[N];
        HashMap<Integer, Integer> h = new HashMap<>();
        int res = 0;
        for (int i = 0; i < N; i++) {
            S[i] = i == 0 ? nums[i] : S[i - 1] + nums[i];
            if (S[i] == k) res++;
            if (h.containsKey(S[i] - k)) {
                res += h.get(S[i] - k);
            }
            if (h.containsKey(S[i])) h.put(S[i], h.get(S[i]) + 1);
            else h.put(S[i], 1);
        }
        return res;
    }
}