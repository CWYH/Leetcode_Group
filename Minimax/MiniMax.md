# 博弈论与游戏

## Leetcode

### Medium
#### 294. Flip Game II ***** -- Medium
* 方法1：回溯法，注意一维数组的clone是深拷贝
* 方法2：Sprague-Grundy定理

#### 375. Guess Number Higher or Lower II ******* -- Meidum
动态规划

```
dp[i][j] = min(k + max(dp[i][k - 1], dp[k + 1][j])) for k in (i, j)
```

注意动态规划的实现方式。
`dp[i][k-1]`和`dp[k + 1][j]`需要在`dp[i][j]`之前计算，因此最外层循环遍历区间长度更好。

```java
    public int getMoneyAmount(int n) {
        if (n <= 1) return 0;
        int[][] dp = new int[n + 1][n + 1];
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int m = Integer.MAX_VALUE;
                for (int k = i; k < i + len - 1; k++) {
                    m = Math.min(m, k + Math.max(dp[i][k - 1], dp[k + 1][i + len - 1]));
                }
                dp[i][i + len - 1] = m;
            }
        }
        return dp[1][n];
    }
```

#### 464. Can I Win***** -- Medium 
自顶向下， DFS。

使用HashMap保存中间状态，减少重复计算。

使用bit来保存当前使用过得数字。


#### 486. Predict the Winner*** -- Medium
方法一： 自顶向下DFS，时间复杂度$O(2^N)$。

方法二： DP
设`dp[i][j]`表示当剩下的数为`nums[i...j]`时，当前操作的选手（注意，不一定是先手）与另一位选手最多的分数差。状态转移方程为：
```
dp[i][j] = max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1])
dp[i][i] = nums[i]
```
如果`dp[0][N-1] >= 0` 先手必胜。

```java
    public boolean PredictTheWinner(int[] nums) {
        if (nums.length <= 2) return true;
        final int N = nums.length;
        int[][] dp = new int[N][N];
        for (int i = N - 1; i >= 0; i--) {
            dp[i][i] = nums[i];
            for (int j = i + 1; j < N; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][N - 1] >= 0;
    }
```