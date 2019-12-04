/**
 * 1. Two Sum -- Easy 
 */

#include <iostream>
#include <unordered_map>
using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> res = {0, 0};
        unordered_map<int, int> h;
        for (int i = 0; i < nums.size(); i++) {
            if (h.find(target - nums[i]) == h.end()) {
                h[nums[i]] = i;
            } else {
                res[0] = h[target - nums[i]];
                res[1] = i;
                break;
            }
        }
        return res;
    }
};