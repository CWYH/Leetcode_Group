/**
 * 154. Find Minimum in Rotated Sorted Array II -- Hard
 *
 * The array may contain duplicates.
 */

//
// Just handle the case that nums[0] == nums[n - 1]
// Make sure nums[0] > nums[hi] before the binary search algorithm begins  
//

#include <vector>
using namespace std;

class Solution {
public:
    int findMin(vector<int>& nums) {
    	if (nums.size() == 1) return nums[0];
        int lo = 0;
        int hi = nums.size() - 1;
        while (hi >= 0 && nums[0] == nums[hi]) {
        	hi--;
        }
        if (hi == -1) return nums[0];  // all elements are equal

        int mid = 0;
        while (lo < hi) {
        	mid = lo + ((hi - lo) >> 1);
        	if (nums[mid] > nums[mid + 1]) {
        		return nums[mid + 1];
        	} else if (nums[mid] >= nums[0]) {
        		lo = mid + 1;
        	} else {
        		hi = mid;
        	}
        }

        return nums[0];
    }
};