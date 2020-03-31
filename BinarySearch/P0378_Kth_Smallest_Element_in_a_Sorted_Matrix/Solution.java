/**
 * 378. Kth Smallest Element in a Sorted Matrix -- Medium
 *
 * MS
 */

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        final int n = matrix.length;
        int lo = matrix[0][0];
        int hi = matrix[n - 1][n - 1];
        int mid = 0;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            int num = 0;
            int j = n - 1;
            for (int i = 0; i < n; i++) {
                while (j >= 0 && matrix[i][j] > mid) j--;
                num += (j + 1);
            }
            if (num < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int k = 7;
        System.out.println(s.kthSmallest(matrix, k));
    }
}