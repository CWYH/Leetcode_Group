# Tree

## Leetcode

### Medium
#### 331. Verify Preorder Serialization of a Binary Tree *****
利用树的节点度特性判断是否为二叉树。
对于一颗树的节点（除了根节点）：
* 如果为空节点，出度=0，入度=1.
* 如果为非空节点，出度=2，入度=1.

每一条边都对应着一个出度和一个入度，因此二叉树的总出度-总入度=0.

我们考虑`diff = outdegree - indgree`. 一开始在根节点，`diff=1`(假设有一个入边指向根节点，然后一开始循环中`diff--`, 就消除了影响，保证循环中考虑的都是实际的边的出入度), 碰到每一个节点，有`indgree++`, 因此`diff--`; 若为非空节点，有`outdgree+=2`, 因此`diff+=2`. 如果是一棵树，那么在此过程中必然有`diff >= 0`（因为每次碰到一条边都先加了出度（非空节点），然后再减入度）, 且最终`diff==0`.

```java
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) return true;
        String[] preArray = preorder.split(",");
        int diff = 1;  // diff = outdgree - indegree
        for (String node : preArray) {
            diff--;
            if (diff < 0) return false;
            if (!node.equals("#")) {
                diff += 2;
            }
        }
        return diff == 0;
    }
```

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

#### 450. Delete Node in BST -- Medium
删除节点，一次性写对感觉还蛮难的。

### Hard 
#### 99. Recover Binary Search Tree
Morries Traversal ??
