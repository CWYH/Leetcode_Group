/**
 * Chapter 13 DP
 * 13.5
 * 
 * 123. Best Time to Buy and Sell Stock III -- Hard
 */

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

/**
 * 
 * max{f(i) + g(i)}
 */ 

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        const int n = prices.size();
        if (n <= 1) return 0;
        vector<int> f(n, 0);
        vector<int> g(n, 0);

        int valley = prices[0];
        for (int i = 1; i < n; i++) {
            f[i] = max(f[i - 1], prices[i] - valley);
            valley = min(valley, prices[i]);
        }

        int top = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            g[i] = max(g[i + 1], top - prices[i]);
            top = max(top, prices[i]);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res = max(res, f[i] + g[i]);
        }
        return res;
    }
};