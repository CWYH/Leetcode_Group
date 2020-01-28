import java.util.HashSet;

/**
 * 457. Circular Array Loop -- Medium
 */

class Solution {
    public boolean circularArrayLoop(int[] nums) {
        if (nums.length <= 1) return false;
        HashSet<Integer> set = new HashSet<>();
        int slow = 0, fast = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(i)) continue;
            slow = i;
            fast = getNextIndex(nums, i);
            while (!set.contains(fast) && !set.contains(getNextIndex(nums, fast))
                    && nums[fast] * nums[i] > 0 && nums[getNextIndex(nums, fast)] * nums[i] > 0) {
                if (slow == fast) {
                    if (getNextIndex(nums, slow) != fast) {
                        return true;
                    } else {
                        break;
                    }
                }
                slow = getNextIndex(nums, slow);
                fast = getNextIndex(nums, fast);
                fast = getNextIndex(nums, fast);
            }

            int j = i;
            while (nums[j] * nums[i] > 0 && !set.contains(j)) {
                set.add(j);
                j = getNextIndex(nums, j);
            }
        }

        return false;
    }

    private int getNextIndex(int[] nums, int i) {
        int next = i + nums[i];
        while (next < 0) next += nums.length;
        next %= nums.length;
        return next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2, 1, 1, -1};
        System.out.println(s.circularArrayLoop(nums));
    }
}