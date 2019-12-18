/**
 * 376. Wiggle Subsequence -- Medium
 */


class Solution {
    /**
     * 1. 普通动态规划
     */
    // public int wiggleMaxLength(int[] nums) {
    //     final int N = nums.length;
    //     if (N <= 1) return N;
    //     int[] up = new int[N];     // 目前为止最长的以第i个元素结尾的上升摆动序列的长度
    //     int[] down = new int[N];   // 目前为止最长的以第i个元素结尾的下降摆动序列的长度
    //     for (int i = 1; i < N; i++) {
    //         for (int j = 0; j < i; j++) {
    //             if (nums[i] > nums[j]) {
    //                 up[i] = Math.max(up[i], down[j] + 1);
    //             } else if (nums[i] < nums[j]) {
    //                 down[i] = Math.max(down[i], up[j] + 1);
    //             }
    //         }
    //     }
    //     return 1 + Math.max(up[N - 1], down[N - 1]);
    // }

    /**
     * 2. 线性动态规划
     */
    // public int wiggleMaxLength(int[] nums) {
    //     final int N = nums.length;
    //     if (N <= 1) return N;
    //     int[] up = new int[N];    
    //     int[] down = new int[N];   
    //     for (int i = 1; i < N; i++) {
    //         if (nums[i - 1] < nums[i]) {
    //             up[i] = down[i - 1] + 1;
    //             down[i] = down[i - 1];
    //         } else if (nums[i - 1] > nums[i]) {
    //             up[i] = up[i - 1];
    //             down[i] = up[i - 1] + 1;
    //         } else {
    //             up[i] = up[i - 1];
    //             down[i] = down[i - 1];
    //         }
    //     }
    //     return 1 + Math.max(up[N - 1], down[N - 1]);
    // }

    /**
     * 优化空间复杂度的线性动态规划
     */ 
    public int wiggleMaxLength(int[] nums) {
        final int N = nums.length;
        if (N <= 1) return N;
        int up = 0;
        int down = 0;
        for (int i = 1; i < N; i++) {
            if (nums[i - 1] < nums[i]) {
                up = down + 1;
            } else if (nums[i - 1] > nums[i]) {
                down = up + 1;
            }
        }
        return 1 + Math.max(up, down);
    }
}