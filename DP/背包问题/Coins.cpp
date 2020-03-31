/**
 * 硬币问题
 * 1元，2元，5元的硬币若干枚，凑成100元有多少种不同的凑法？
 */

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int getNumOfMethods(vector<int>& coins, int target) {
    int N = coins.size();
    vector<int> dp(target + 1, 0);
    dp[0] = 1;
    for (int i = 0; i < coins.size(); i++) {
        for (int j = coins[i]; j <= target; j++) {
            dp[j] = dp[j] + dp[j - coins[i]];
        }
    }
    return dp[target];
}

int main() {
	vector<int> coins = { 1, 2, 5 };
	int money = 10000;
	cout << getNumOfMethods(coins, money) << endl;
	return 0;
}