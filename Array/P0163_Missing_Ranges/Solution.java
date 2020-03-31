import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 163. Missing Ranges -- Medium
 * 
 * Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its missing ranges.
 * Example:
 * Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99
 * Output: ["2", "4->49", "51->74", "76->99"]
 */

class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new LinkedList<>();
        ArrayList<Long> arr = new ArrayList<>();
        arr.add((long)lower - 1);
        for (int e : nums) arr.add((long)e);
        arr.add((long)upper + 1);
        for (int i = 1; i < arr.size(); i++) {
            long a = arr.get(i - 1);
            long b = arr.get(i);
            if (a < b - 1) {
                String str = a == b - 2 ? String.valueOf(a + 1) : String.valueOf(a + 1) + "->" + String.valueOf(b - 1);
                res.add(str);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {0, 1, 3, 50, 75};
        int lower = 0;
        int upper = 99;
        List<String> res = s.findMissingRanges(nums, lower, upper);
        for (String str : res) {
            System.out.println(str);
        }
    }
}