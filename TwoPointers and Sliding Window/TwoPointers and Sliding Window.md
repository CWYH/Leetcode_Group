# Two Pointers and Sliding Window 双指针法和滑动窗法

## 经典滑动窗
两个指针维护一个窗口：`left`, `right`
* 窗口扩张：`left`不变，`right++;`
* 窗口平移：`left++; right++;`


## Leetcode

### Easy
### Medium
#### 159. Longest Substring with At Most Two Distinct Characters -- Medium
注意的测试点："ababaaaccc"

#### 259. 3Sum Smaller -- Medium
时间复杂度$O(n^2)$

3sum转化为2sum，用双指针解决。

```java
class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            sum += twoSumSmaller(nums, i + 1, target - nums[i]);
        }
        return sum;
    }

    private int twoSumSmaller(int[] nums, int startIndex, int target) {
        int sum = 0;
        int left = startIndex;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                sum += right - left;
                left++;
            } else {
                right--;
            }
        }
        return sum;
    }
}
```

#### 424. Longest Repeating Character Replacement***** -- Medium

#### 457. Circular Array Loop **** -- Medium 
快慢指针

#### 487. Max Consecutive Ones II -- Medium
双指针，保留上一个0出现的位置。



### Hard
#### 76. Minimum Window String ***** -- Hard
双指针
动态维护一个区间。尾指针不断后扫，当扫到有一个窗口包含了所有T的字符后，然后再收缩头指针，直到不能收缩为止(保证窗口中包含所有的T的字符)。最后记录所有可能的情况中窗口最小的。