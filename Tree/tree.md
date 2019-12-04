# Tree

## Leetcode

### Medium
#### 333. Largest BST Subtree
Very Interesting.
BST的根节点比其左子树的最大值大，比右子树的最小值小。

#### 366. Find Leaves of Binary Tree*** -- Medium
用HashMap保存每个节点的深度。

#### 510. Inorder Successor in BST II -- Medium
这题好烦啊
* 1. 若有Right，则找右子树的最小节点
* 2. 否则，找第一个为左孩子的父节点即可

#### 545***. Boundry of Binary Tree -- Medium
有点复杂。
分段处理。
* 1. 根节点
* 2. 左边界
* 3. 底边界 -- 通过先序遍历，保留叶子结点
* 4. 右边界

### Hard 
#### 99. Recover Binary Search Tree
Morries Traversal ??
