# Binary Search

## Leetcode

### Easy

#### 475. Heaters -- Easy
对于每一个house， 在heaters中二分查找它的位置，找到最近的heater。这样所有最近的heater距离的最大值就是结果。

### Medium
#### 240. Search a 2D Matrix II -- Microsoft
从最后一列往前开始二分查找，逐渐逼近。

#### 378. Kth Smallest Element in a Sorted Matrix *** -- Microsoft
二分查找，每次计算$\le$`mid`的数的个数。

注意返回值，循环结束后返回`lo`。