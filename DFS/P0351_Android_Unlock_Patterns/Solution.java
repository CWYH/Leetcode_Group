/**
 * 351. Android Unlock Patterns -- Medium
 * 
 * Microsoft, Google, Apple
 * 
 * Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, 
 * count the total number of unlock patterns of the Android lock screen, which consist 
 * of minimum of m keys and maximum n keys.
 * 
 * Rules for a valid pattern:
 * 
 * 1. Each pattern must connect at least m keys and at most n keys.
 * 2. All the keys must be distinct.
 * 3. If the line connecting two consecutive keys in the pattern passes through any other
 *    keys, the other keys must have previously selected in the pattern. No jumps through 
 *    non selected key is allowed.
 * 4. The order of keys used matters.
 * 
 * Example:
 *     Input: m = 1, n = 1
 *     Output: 9
 */

class Solution {
    // public int numberOfPatterns(int m, int n) {
    //     if (n <= 0) return 0;
    //     if (m > n) return 0;
    //     boolean[][] vis = new boolean[3][3];

    // }
}