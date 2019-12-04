/**
 * 5. Longest Palindromic Substring -- Medium
 */

#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    string longestPalindrome(string s) {
        const int N = s.size();
        string res = "";
        vector<vector<bool>> P(N, vector<bool>(N, false));
        for (int i = N - 1; i >= 0; i--) {
            for (int j = i; j < N; j++) {
                if (i + 1 <= j) {
                    P[i][j] = s[i] == s[j];
                } else {
                    P[i][j] = s[i] == s[j] && P[i + 1][j - 1];
                }

                if (P[i][j] && j - i + 1 > res.size()) {
                    res = s.substr(i, j - i + 1);
                }
            }
        }

        return res;
    }
};