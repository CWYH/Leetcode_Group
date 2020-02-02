# Stack
## Leetcode
### Easy
#### 496. Next Greater Element I -- Easy
单调栈

### Medium
#### 255. Verify Preorder Sequence in Binary Search Tree***** -- Medium
单调栈。

二叉搜索树的前序遍历有以下特点：
* 如果出现递减序列，则是左子树，否则是右子树；
* 右子树一定是递增的
  
综上，我们可以通俗理解为“总体递增，局部递减”。为了达到“总体递增的效果”，我们要保证递减序列的第一个元素小于递减结束后即将递增的那个元素。


#### 402. Remove K Digits -- Medium
单调栈 -- 维护一个递增栈，但当前元素小于栈顶元素，则移掉栈顶元素。

#### 456. 132 Pattern *** -- Medium
好难。。。


### Hard
#### 84. Largest Rectangle in Histogram ***** -- Hard
经典题，单调栈。
