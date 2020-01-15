import java.util.*;

/**
 * 360. Sorted Transformed Array -- Medium
 */

class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        final int N = nums.length;
        int[] res = new int[N];
        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();
        if (a == 0) {
            for (int i = 0; i < N; i++) {
                res[i] = b >= 0 ? f(a, b, c, nums[i]) : f(a, b, c, nums[N - 1 - i]);
            }
            return res;
        }

        int x_mid = -b / a / 2;
        for (int i = 0; i < N; i++) {
            if (nums[i] < x_mid) l1.add(f(a, b, c, nums[i]));
            else l2.add(f(a, b, c, nums[i]));
        }
        if (a < 0) {
            LinkedList<Integer> tmp = new LinkedList<>(l2);  // ?
            l2 = l1;
            l1 = tmp;
        }

        int i1 = l1.size() - 1;
        int i2 = 0;
        for (int i = 0; i < N; i++) {
            int cur = 0;
            if (i1 < 0) cur = l2.get(i2++);
            else if (i2 >= l2.size()) cur = l1.get(i1--);
            else {
                if (l1.get(i1) > l2.get(i2)) cur = l2.get(i2++);
                else cur = l1.get(i1--);
            }
            res[i] = cur;
        }
        return res;
    }

    private int f(int a, int b, int c, int x) {
        return a * x * x + b * x + c;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {-4, -2, 2, 4};
        int a = -1;
        int b = 3;
        int c = 5;
        int[] res = s.sortTransformedArray(nums, a, b, c);
        for (int i = 0; i < res.length; i++) {
            System.out.printf("%d ", res[i]);
        }
    }
}