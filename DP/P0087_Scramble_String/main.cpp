/**
 * 87. Scramble String -- Hard
 */

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
	/**
	 * DP
	 * Time:  O(n^3)
	 * Space: O(n^3)
	 *
	 * 设f[n][i][j]表示长度为n，起点为s1[i]和起点为s2[j]两个字符是否互为scramble, 则状态转移方程为：
	 *    f[n][i][j] = (f[k][i][j] && f[n - k][i + k][j + k])
	 *               || (f[k][i][j + n - k] && f[n - k][i + k][j])
	 */
	bool isScramble(const string& s1, const string& s2) {
		const int N = s1.size();
		if (N != s2.size()) return false;
		vector<vector<vector<bool>>> f(N + 1, vector<vector<bool>>(N, vector<bool>(N, false)));
		for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                f[1][i][j] = (s1[i] == s2[j]);
            }
        }

        for (int n = 1; n <= N; n++) {
            for (int i = 0; i + n <= N; i++) {
                for (int j = 0; j + n <= N; j++) {
                    for (int k = 1; k < n; k++) {
                        f[n][i][j] = (f[k][i][j] && f[n - k][i + k][j + k])
                                || (f[k][i][j + n - k] && f[n - k][i + k][j]);
                        if (f[n][i][j]) break;
                    }
                }
            }
        }

        return f[N][0][0];
	}
};
