/**
 * 373. Find K Pairs with Smallest Sums -- Medium
 */

#include <iostream>
#include <vector>
#include <queue>
using namespace std;

struct CMP {
    bool operator() (const vector<int> & v1, const vector<int> & v2) const {
        return v1[0] + v1[1] > v2[0] + v2[1];
    }
};

class Solution {
public:
    vector<vector<int>> kSmallestPairs(vector<int>& nums1, vector<int>& nums2, int k) {
        vector<vector<int>> res;
        if (nums1.size() == 0 || nums2.size() == 0 || k == 0) return res;

        priority_queue<vector<int>, vector<vector<int>>, CMP> pq;
        for (int i = 0; i < nums1.size(); i++) {
            pq.push({nums1[i], nums2[0], 0});
        }

        while (k-- && !pq.empty()) {
            vector<int> v = pq.top();
            pq.pop();
            res.push_back({v[0], v[1]});
            if (v[2] >= nums2.size() - 1) continue;
            pq.push({v[0], nums2[v[2] + 1], v[2] + 1}); 
        }
        return res;
    }
};