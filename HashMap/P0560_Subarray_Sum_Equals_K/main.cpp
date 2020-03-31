/**
 * 560. Subarray Sum Equals k -- Medium
 */

//
// 遍历时用Hash表存储 和S[i]出现的次数
//

#include <vector>
#include <unordered_map>
using namespace std;

class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        const int n = nums.size();

        unordered_map<int, int> h;
        int res = 0;
        vector<int> S(n, 0);
        h[0] = 1;   // Attention!
        for (int i = 0; i < n; i++) {
            S[i] = i == 0 ? nums[i] : S[i - 1] + nums[i];
            if (h.find(S[i] - k) != h.end()) {
                res += h[S[i] - k];
            }
            if (h.find(S[i]) == h.end()) h[S[i]] = 1;
            else h[S[i]]++;
        }

        return res;
    }
};