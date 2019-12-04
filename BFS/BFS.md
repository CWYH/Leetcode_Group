# BFS
## Leetcode
### Medium
#### 310. Minimum Height Trees*****
树 -- 即无环图
* 思路类似于Topological Sort, 从度为1的节点（叶子节点）开始，依次向内遍历，每次遍历只遍历一个节点，删去原先的叶子节点，再从新的叶子节点开始如法炮制，知道剩下一个或者两个节点为止。