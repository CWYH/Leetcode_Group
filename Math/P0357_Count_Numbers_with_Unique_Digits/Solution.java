/**
 * 357. Count Numbers with Unique Digits -- Medium
 */

class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;
        int[] F = new int[11];
        F[1] = 10;
        F[2] = 81;
        for (int i = 3; i <= 10; i++) {
            F[i] = F[i - 1] * (11 - i);
        }
        int res = 0;
        for (int i = 1; i <= Math.min(n, 10); i++) {
            res += F[i];
        }
        return res;
    }
}