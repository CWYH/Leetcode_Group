/**
 * 313. Super Ugly Number -- Medium
 */

// Familiar with leetcode 264

#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
using namespace std;

typedef long long ll;

class Solution {
public:
    int nthSuperUglyNumber(int n, vector<int>& primes) {
        const size_t k = primes.size();
        vector<ll> v(n, INT_MAX);
        v[0] = 1;
        vector<int> index(k, 0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                v[i] = min(v[i], v[index[j]] * primes[j]);
            }
            for (int j = 0; j < k; j++) {
                if (v[i] == v[index[j]] * primes[j]) index[j]++;
            }
        }
        return (int)v[n - 1];
    }
};

int main() {
//    int n = 15;
//    vector<int> primes = {3,5,7,11,19,23,29,41,43,47};
    int n = 12;
    vector<int> primes = {2, 7, 13, 19};
    Solution s;
    cout << s.nthSuperUglyNumber(n, primes) << endl;
    return 0;
}
