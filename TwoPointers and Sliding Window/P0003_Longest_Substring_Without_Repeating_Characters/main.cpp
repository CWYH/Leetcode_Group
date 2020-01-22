/**
 * 3. Longest Substring Without Repeating Characters -- Medium
 */ 

#include <string>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if (s.size() <= 1) return s.size();
        vector<int> last(256, -1);
        int i = 0, j = 0;
        int res = 0;
        while (j < s.size()) {
            if (last[s[j]] >= i) {
                res = max(res, j - last[s[j]]);
                i = last[s[j]] + 1;
            } else {
                res = max(res, j - i + 1);
            }
            last[s[j]] = j;
            j++;
        }

        return res;
    }
};