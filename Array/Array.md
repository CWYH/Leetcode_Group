# Array
## Leetcode
### Easy

#### 169. Majority Element -- Easy
时间: $O(N)$, 一次遍历
空间：$O(1)$

详见229题

#### 243. Shortest Word Distance -- Easy
分别保存两个词在数组中的下标，再将第二个词的下标到第一个词的下标数组中二分查找最近的一个下标。

### Medium
#### 229. Majority Element II ***
Bayor-Moore Algorithm
两次遍历，对于最多有$k$个可能的majority element, 时间复杂度$O(kN)$, 空间复杂度$O(k)$. 对于本题，$\lfloor n/3 \rfloor$表明最多有$k=2$种majority emelent的可能.
* 第一次遍历：找到$k$种可能数(candidates)
* 第二次遍历：检验每个candidate的个数是否满足条件.


[https://leetcode.com/problems/majority-element-ii/discuss/63520/Boyer-Moore-Majority-Vote-algorithm-and-my-elaboration]

[https://gregable.com/2013/10/majority-vote-algorithm-find-majority.html]