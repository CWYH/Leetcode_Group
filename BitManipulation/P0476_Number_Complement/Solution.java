/**
 * 476. Number Complement -- Medium
 */

class Solution {
    public int findComplement(int num) {
        if (num <= 0) return 0;
        int n = num;
        int k = 0;
        while (n > 1) {
            n >>= 1;
            k++;
        }
        return (2 << k) - 1 - num;
    }
}