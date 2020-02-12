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

#### 449. Serialize and Deserialize BST* -- Medium
和297题很相似。
C++使用sstream, Java使用StringBuilder。

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

#### 1245. Tree Diameter***** -- Medium
方法1：类似题124.
DFS，以任意一点为root，与其关联的点为子节点，求出所有子节点对应的路径的前两大值max1,max2，则该点对应的最长路径为max1+max2。

方法2：两次搜索
一般求解树的直径的问题，最简单高效的方法是先从任意一个点出发进行搜索，直到走到一个最远的点，我们可以证明这个点一定是直径的一个端点，然后再从这个点为起点进行搜索，直到到达从该点出发到达的最远的点，其经过的路径一定是树的直径。

作者：SHU_YKC
链接：https://leetcode-cn.com/problems/tree-diameter/solution/liang-ci-sou-suo-fang-fa-yi-dong-gan-diao-100-by-s/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

### Hard 
#### 99. Recover Binary Search Tree
Morries Traversal ??

#### 124. Binary Tree Maximum Path Sum***** -- Hard
DFS
```java
class Solution {
    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private int max_sum;

    public int maxPathSum(TreeNode root) {
        max_sum = Integer.MIN_VALUE;
        dfs(root);
        return max_sum;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        int sum = root.val;
        if (l > 0) sum += l;
        if (r > 9) sum += r;
        max_sum = Math.max(sum, max_sum);
        return Math.max(l, r) > 0 ? Math.max(l, r) + root.val : root.val;
    }
}
```
