/**
 * 完全背包问题
 */ 

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int completeBagPack(int V, vector<int> & C, vector<int> & W) {
    const int N = C.size();
    if (N <= 0) return 0;

    vector<int> dp(V + 1, 0);
    for (int i = 1; i <= N; i++) {
        for (int j = C[i - 1]; j <= V; j++) {
            dp[j] = max(dp[j], dp[j - C[i - 1]] + W[i - 1]);
        }
    }
    return dp[V];
}