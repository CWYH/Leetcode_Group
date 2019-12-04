import java.util.*;

/**
 * 496. Next Greater Element I -- Easy
 */

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stk = new Stack<>();
        HashMap<Integer, Integer> h = new HashMap<>();
        final int n1 = nums1.length;
        final int n2 = nums2.length;
        for (int i = n2 - 1; i >= 0; i--) {
            while (!stk.isEmpty()) {
                if (nums2[i] < nums2[stk.peek()]) {
                    h.put(nums2[i], stk.peek());
                    stk.push(i);
                    break;
                } else {
                    stk.pop();
                }
            }
            if (stk.size() == 0) {
                h.put(nums2[i], -1);
                stk.push(i);
            }
        }

        int[] res = new int[n1];
        for (int i = 0; i < n1; i++) {
            int r = h.getOrDefault(nums1[i], -1);
            if (r != -1) r = nums2[r];
            res[i] = r;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] res = s.nextGreaterElement(nums1, nums2);
        for (int e : res) {
            System.out.print(e + " ");
        }
    }
}