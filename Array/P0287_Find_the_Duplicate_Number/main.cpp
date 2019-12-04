/**
 * 287. Find the Duplicate Number -- Medium
 */

//
// Cycle Detection
// Familiar with Linked List Cycle II -- see https://leetcode.com/articles/find-the-duplicate-number/
//


#include <vector>
using namespace std; 

class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        if (nums.size() == 0) return 0;
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (nums[slow] != nums[fast]);

        int p1 = 0, p2 = slow;
        while (p1 != p2) {
            p1 = nums[p1];
            p2 = nums[p2];
        }
        return p1;
    }
};