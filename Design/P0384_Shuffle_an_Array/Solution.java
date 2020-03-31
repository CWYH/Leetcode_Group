import java.util.Random;

/**
 * 384. Shuffle an Array
 */

class Solution {

    private int[] origin;
    private int[] nums;

    public Solution(int[] nums) {
        this.origin = nums.clone();
        this.nums = nums.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return origin;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for (int i = nums.length - 1; i >= 0; i--) {
            Random r = new Random();
            int index = r.nextInt(i + 1);
            int tmp = nums[index];
            nums[index] = nums[i];
            nums[i] = tmp;
        }
        return nums;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */