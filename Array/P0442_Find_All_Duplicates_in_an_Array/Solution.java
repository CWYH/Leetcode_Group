import java.util.HashSet;
import java.util.LinkedList;

/**
 * 442. Find All Duplicates in an Array -- Medium
 */

class Solution {
    /**
     * 聪明绝顶的算法
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int v = Math.abs(nums[i]);
            if (nums[v - 1] < 0) {
                res.add(v);
            } else {
                nums[v - 1] = -nums[v - 1];
            }
        }
        return res;
    }

    // public List<Integer> findDuplicates(int[] nums) {
    //     HashSet<Integer> hs = new HashSet<>();
    //     for (int i = 0; i < nums.length; i++) {
    //         while (nums[i] != i + 1) {
    //             if (nums[i] == nums[nums[i] - 1]) {
    //                 hs.add(nums[i]);
    //                 break;
    //             }
    //             swap(nums, i, nums[i] - 1);
    //         }
    //     }

    //     List<Integer> res = new LinkedList<>();
    //     for (Integer e : hs) {
    //         res.add(e);
    //     }
    //     return res;
    // }

    // private void swap(int[] nums, int i, int j) {
    //     int tmp = nums[i];
    //     nums[i] = nums[j];
    //     nums[j] = tmp;
    // }
}