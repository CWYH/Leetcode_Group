/**
 * 01背包问题
 */

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

/**
 * V: 最大容量
 * C: 耗费容量
 * W: 得到价值
 */ 
int backpack01(int V, vector<int>& C, vector<int>& W) {
    const int N = C.size();

    // dp[i][j]: 放前i件物品, 最大容量j的背包，得到的最大价值
    vector<vector<int>> dp(N + 1, vector<int>(V + 1, 0));
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= V; j++) {
            if (j < C[i - 1]) {
                dp[i][j] = dp[i - 1][j];
            } else {
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - C[i - 1]] + W[i - 1]);
            }
        }
    }

    return dp[N][V];
}

/**
 * 优化空间复杂度
 */
void zeroOnePack(int V, int Ci, int Wi, vector<int>& dp) {
    for (int j = V; j >= Ci; j--) {
        dp[j] = max(dp[j], dp[j - Ci] + Wi);
    }
}

int backpack01_better(int V, vector<int>& C, vector<int>& W) {
    const int N = C.size();
    vector<int> dp(V + 1, 0);
    for (int i = 1; i <= N; i++) {
        zeroOnePack(V, C[i - 1], W[i - 1], dp);
    }

    return dp[V];
}

int main() {
	int N = 5;
	int V = 7;
	vector<int> C = {3, 5, 1, 2, 2};
	vector<int> W = {4, 5, 2, 1, 3};

	int r1 = backpack01(V, C, W);
	cout << r1 << endl;

	int r2 = backpack01_better(V, C, W);
	cout << r2 << endl;

	return 0;
}
