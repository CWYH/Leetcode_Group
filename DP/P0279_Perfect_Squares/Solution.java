/**
 * 279. Perfect Squares -- Medium
 */

class Solution {
    public int numSquares(int n) {
        if (n == 1) return 1;
        int[] F = new int[n + 1];
        F[1] = 1;
        int k = 2;
        for (int i = 2; i <= n; i++) {
            if (k * k == i) {
            	F[i] = 1;
            	k++;
            } else {
            	F[i] = F[i - 1] + 1;
            	for (int j = 1; j * j <= i / 2; j++) {
                    F[i] = Math.min(F[i], F[i - j * j] + 1);
                }
            }
        } 
        return F[n];
    }
}
