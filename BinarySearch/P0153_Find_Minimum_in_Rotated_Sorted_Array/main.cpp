/**
 * 153. Find Minimum in Rotated Sorted Array -- Medium
 */

//
// Binary Search
//
// pay attention to the case that no rotation 
//

#include <vector>
using namespace std;

class Solution {
public:
    int findMin(vector<int>& nums) {
        if (nums.size() == 1) return nums[0];
        int lo = 0, hi = nums.size() - 1;
        int mid = 0;
        while (lo < hi) {
            mid = ((hi - lo) >> 1) + lo;
            if (nums[mid] < nums[mid + 1]) {
            	if (nums[mid] > nums[0]) lo = mid + 1;
            	else hi = mid;
            } else {
            	return nums[mid + 1];
            }
        }

        return nums[0];
    }
};