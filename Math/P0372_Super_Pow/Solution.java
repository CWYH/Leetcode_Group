/**
 * 372. Super Pow -- Medium
 */

class Solution {
    /**
     * 方法一:
     * (ab) % p = ((a % p) * (b % p)) % p
     *
     * a^b % p = [ ((a^(b/10))^10 % p) * (a^(b%10) % p) ] % p
     */
//    private final int p = 1337;

//    public int superPow(int a, int[] b) {
//        return superPow(a, b, b.length - 1);
//    }
//
//    private int superPow(int a, int[] b, int idx) {
//        if (idx < 0) return 1;
//        return powmod(superPow(a, b, idx - 1), 10) * powmod(a, b[idx]) % p;
//    }
//
//    private int powmod(int a, int k) {
//        int res = 1;
//        a %= p;
//        for (int i = 0; i < k; i++) {
//            res = (res * a) % p;
//        }
//        return res;
//    }

    /**
     * 方法2：欧拉定理
     */
    public int superPow(int a, int[] b) {
        if (a % 1337 == 0) return 0;
        int b_num = 0;
        for (int i = 0; i < b.length; i++) {
            b_num = (b_num * 10 + b[i]) % 1140;
        }
        if (b_num == 0) b_num += 1140;
        return powerMod(a, b_num, 1337);
    }

    private int powerMod(int a, int b_num, int M) {
        a %= M;
        int res = 1;
        while (b_num != 0) {
            if ((b_num & 1) != 0) res = res * a % M;
            a = a * a % M;
            b_num >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int a = 2;
        int[] b = {1, 3, 9, 9};
        System.out.println(s.superPow(a, b));
    }
}