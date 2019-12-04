# Two Pointers 双指针法

## Leetcode

### Easy
### Medium
### Hard
#### 76. Minimum Window String -- Hard
双指针
动态维护一个区间。尾指针不断后扫，当扫到有一个窗口包含了所有T的字符后，然后再收缩头指针，直到不能收缩为止。最后记录所有可能的情况中窗口最小的。