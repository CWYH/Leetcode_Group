# Heap

## Leetcode

### Medium

#### 373. Find K Pairs with Smallest Sums***
优先队列，时间复杂度$k\log(k)$

将原问题转换成在n1个升序队列中，查找最小的前$k$对数字。为了解决该问题，我们可以参考leetcode 23 合并K个有序链表的方法。我们统计n1个升序队列的队首元素中的最小值，将其加入结果队列，并将指向该队首的指针向后移，直到我们找齐前K对数字。
