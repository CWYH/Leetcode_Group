/**
 * 240. Search a 2D Matrix II -- Medium
 * 
 * Binary Search
 * 
 * Microsoft
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        final int M = matrix.length;
        if (M <= 0) return false;
        final int N = matrix[0].length;
        if (N <= 0) return false;

        int j = N - 1;
        int i = 0;
        while (j >= 0) {
            int pos = binarySearch(matrix, j, i, target);
            if (pos >= M) {
                return false;
            }
            if (matrix[pos][j] == target) {
                return true;
            } else {
                j--;
                i = pos;
            }
        }
        return false;
    }

    private int binarySearch(int[][] matrix, int row, int i, int target) {
        int lo = i;
        int hi = matrix.length - 1;
        int mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (target < matrix[mid][row]) {
                hi = mid - 1;
            } else if (matrix[mid][row] < target) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }
}