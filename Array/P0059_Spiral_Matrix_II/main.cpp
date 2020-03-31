/**
 * 59. Spiral Matrix II -- Medium
 */

// n^2个数

#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
	vector<vector<int>> generateMatrix(int n) {
		if (n == 0) return vector<vector<int>>();
		vector<vector<int>> res(n, vector<int>(n, 0));
		int k = 1;
		int stx = 0, sty = 0, edx = n - 1, edy = n - 1;
		while (k <= n * n) {
			for (int i = stx; i <= edx; i++) {
				res[sty][i] = k++;
			}
			for (int i = sty + 1; i <= edy; i++) {
				res[i][edx] = k++;
			}
			for (int i = edx - 1; i >= stx; i--) {
				res[edy][i] = k++;
			}
			for (int i = edy - 1; i >= sty + 1; i--) {
				res[i][stx] = k++;
			}
			stx++; sty++; edx--; edy--;
		}

		return res;
	}
};

int main() {
	Solution s;
	int n = 3;
	vector<vector<int>> res = s.generateMatrix(n);

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cout << res[i][j] << " ";
		}
		cout << endl;
	}
	return 0;
}