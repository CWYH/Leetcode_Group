/**
 * 666. Path Sum IV -- Medium
 *
 * If the depth of a tree is smaller than 5, then this tree can be represented by a list of three-digits integers.
 * For each integer in this list:
 *     1. The hundreds digit represents the depth D of this node, 1 <= D <= 4
 *     2. The tens digit represents the position P of this node in the level it belongs to, 1 <= P <= 8. 
 *        The position is the same as that in a full binary tree
 *     3. The units digit represents the value V of this node, 0 <= V <= 9
 *
 * Given a list of ascending three-digits integers representing a binary tree with the depth smaller than 5,
 * you need to return the sum of all paths from the root towards the leaves.
 *
 * Example 107
 * Input: [113, 215, 221]
 * Output: 12
 * Explanation:
 * The tree that the list represents is
 *     3
 *    / \
 *   5   1
 * The path sum is (3 + 5) + (3 + 1) = 12
 * 
 * Example 2
 * Input: [113, 221]
 * Output: 4
 * Explanation:
 * The tree that the list represents is:
 *     3
 *      \
 *       1
 * The path sum is (3 + 1) = 4.
 */

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int pathSum(vector<int>& nums) {
        int res = 0;
        vector<int> tree(16, -1);
        for (int i = 0; i < nums.size(); i++) {
            tree[getPos(nums[i])] = nums[i] % 10;
        }
        for (int i = 15; i >= 1; i--) {
            if (tree[i] == -1) continue;
            if (i * 2 > 15 || (tree[i * 2] == -1 && tree[i * 2 + 1] == -1)) {
                int j = i;
                while (j >= 1) {
                    res += tree[j];
                    j /= 2;
                }
            }
        }
        return res;
    }

private:
    int getPos(int a) {
        int n = a / 100;
        int k = (a % 100) / 10;
        return (1 << (n - 1)) + k - 1;
    }
};

int main() {
    Solution s;
    vector<int> nums = {113, 215, 221};
    cout << s.pathSum(nums) << endl;
    return 0;
}