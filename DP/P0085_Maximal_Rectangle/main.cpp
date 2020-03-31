/**
 * Chapter 13  Dynamic Programming
 * 13.4
 * 
 * 85. Maximal Rectangle -- Hard
 */ 

#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

/**
 * 一层一层遍历
  height: 在当前这个位置，从下往上连续的1的个数（包括这个点）
  left: 在当前这个位置，高度为height[j]的满足题意的矩形的左下标。
        0表示在这个位置不存在满足题意的矩形。 从左到右遍历。
  right: 在当前这个位置，高度为height[j]的满足题意的矩形的右下标 + 1。
         n表示在这个位置不存在满足题意的矩形。从右到左遍历。
*/

class Solution {
public:
    int maximalRectangle(vector<vector<char>>& matrix) {
        int m = matrix.size();
        if (m <= 0) return 0;
        int n = matrix[0].size();
        if (n <= 0) return 0;

        vector<int> height(n, 0);
        vector<int> left(n, 0);
        vector<int> right(n, n);
        int res = 0;

        for (int i = 0; i < m; i++) {
            int l = 0, r = n;
            // calculate left(i, j) from left to right
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                    left[j] = max(left[j], l);
                } else {
                    l = j + 1;
                    height[j] = 0;
                    left[j] = 0;
                    right[j] = n;
                }
            }

            // calculate right(i, j) from right to left
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = min(right[j], r);
                    res = max(res, height[j] * (right[j] - left[j]));
                } else {
                    r = j;
                }
            }
        }

        return res;
    }
};