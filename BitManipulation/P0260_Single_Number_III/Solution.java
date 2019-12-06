/**
 * 260. Single Number III -- Medium
 */


class Solution {
    public int[] singleNumber(int[] nums) {
        int x = 0;
        for (int num : nums) {
            x = x ^ num;
        }

        int diff = lowbit(x);

        int[] res = {0, 0};
        for (int num : nums) {
            if ((num & diff) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }

        return res;
    }

    /**
     * lowbit(x)为x的二进制表达式中最右边的1所对应的值.
     * 因此lowbit(x)二进制表达式中只有一个bit 1.
     *
     * 例如: x=1010
     *
     * lowbit(x) = 1010 & 0110 = 0010 = 2
     */
    private int lowbit(int x) {
        return x & (-x);   // also can be x & (~x + 1) -- 2's Complement
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,1,3,2,5};
        int[] res = s.singleNumber(nums);
        System.out.printf("%d %d\n", res[0], res[1]);
    }
}