# Dynamic Programming

## 背包问题

### 0-1背包问题
### 完全背包问题
### 硬币问题
```C++
/**
 * 硬币问题
 * 1元，2元，5元的硬币若干枚，凑成100元有多少种不同的凑法？
 */
int getNumOfMethods(vector<int>& coins, int target) {
    int N = coins.size();
    vector<int> dp(target + 1, 0);
    dp[0] = 1;  // 注意初始化
    for (int i = 0; i < coins.size(); i++) {
        for (int j = coins[i]; j <= target; j++) {
            dp[j] = dp[j] + dp[j - coins[i]];
        }
    }
    return dp[target];
}
```


## 经典DP问题
### 5. 最长回文子串 Longest Palindromic Substring -- Medium
DP: $ dp[i][j] $表示$[i,j]$是否为回文串
```C++
dp[i][j] = i + 1 >= j ? s[i] == s[j] : s[i] == s[j] && dp[i + 1][j - 1]
```


### 53. 最大连续子序和 -- Easy
### 300. 最长上升子序列 Longest Increasing Subsequence -- Medium
#### 解法一：DP -- $O(n^2)$
$dp[i]$表示以$nums[i]$为结尾的LIS长度，则初始化$dp[i]=1$
$$
dp[i] = \max(dp[j] + 1) \quad j < i \quad \&\& \quad nums[j] < nums[i]
$$

#### 解法二：二分查找 -- $O(n\log n)$
从前向后遍历数组$nums$，用另一个数组$A$保存LIS. 在$A$中二分查找$nums[i]$的插入位置. 如果查到位置在最后，则$nums[i]$插入到$A$末尾; 反之若查到位置$k$处$A[k] > nums[i]$, 则$A[k] = nums[i]$.

则LIS长度为$A$的长度.  "$cos(\theta)$"

### 1143. 最长公共子序列 Longest Common Sequence -- Medium
$dp[i][j]$表示$[0..i, 0..j]$的LCS
如果$str1[i] == str2[j]$, 则$dp[i][j] = dp[i - 1][j - 1] + 1$
否则 $dp[i][j] = \max(dp[i - 1][j], dp[i][j - 1])$

## Leetcode
## Easy
### 53. Maximum Subarray -- Easy
设$dp[i]$表示以$nums[i]$为结尾的最大和子数组。
$$
dp[i] = max(dp[i - 1] + nums[i], nums[i]);
$$


## Medium
### 120. Triangle -- Medium
设状态为$dp[i][j]$, 表示从位置$(i, j)$出发,路径的最小和。则状态转移方程为：
    $$
        dp[i][j] = min(dp[i+1][j], dp[i+1][j+1]) + triangle[i][j];
    $$

### 174. Dungeon Game -- Medium
```Cpp
dp[i][j] = min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
if (dp[i][j] <= 0) dp[i][j] = 1;  // make sure that dp[i][j] > 0
```



### 264. Ugly Number II -- Medium
$k=2^{r_1} * 3^{r_2} * 5^{r_3}$

经典题，思路：每一个丑数一定是由之前某一个丑数乘以2或3或5得到。
递推公式即：
$$
k[i] = \min(k[t_2] * 2, \min(k[t_3] * 3, k[t_5] * 5))
$$

### 313. Super Ugly Number -- Meidum
和264题一样，不过要注意去重

### 368. Largest Divisible Subset***** -- Medium
对于已排好序的nums, 设两个数组：
`dp[i]`: 以nums[i]为结尾的序列最大长度；
`last[i]`: 在最大序列中 nums[i]的上一个元素在nums出现的下标.
状态转移方程：
```java
for (int i = 0; i < N; i++) {
    for (int j = 0; j < i; j++) {
        if (nums[i] % nums[j] == 0 && dp[i] <= dp[j]) {
            dp[i] = dp[j] + 1;
            last[i] = j;
        }
    }
    if (dp[i] > maxSize) {
        maxSize = dp[i];
        end = i;
    }
}
```

### 376. Wiggle Subsequence* -- Medium
动态规划
#### 1. 基本思路
为了更好地理解这一方法，用两个数组来dp，分别记作up和down。

每当我们选择一个元素作为摆动序列的一部分时，这个元素要么是上升的，要么是下降的，这取决于前一个元素的大小。

up[i]存的是目前为止最长的以第i个元素结尾的上升摆动序列的长度。
类似地， down[i]记录的是目前为止最长的以第i个元素结尾的下降摆动序列的长度。

我们每当找到将第i个元素作为上升摆动序列的尾部的时候就更新 up[i] 。现在我们考虑如何更新 up[i]，我们需要考虑前面所有的降序结尾摆动序列，也就是找到 down[j] ，满足$j<i$ 且 $nums[i]>nums[j]$ 。类似的， down[i]也会被更新。
```java
class Solution {
    public int wiggleMaxLength(int[] nums) {
        final int N = nums.length;
        if (N <= 1) return N;
        int[] up = new int[N];     // 目前为止最长的以第i个元素结尾的上升摆动序列的长度
        int[] down = new int[N];   // 目前为止最长的以第i个元素结尾的下降摆动序列的长度
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    up[i] = Math.max(up[i], down[j] + 1);
                } else if (nums[i] < nums[j]) {
                    down[i] = Math.max(down[i], up[j] + 1);
                }
            }
        }
        return 1 + Math.max(up[N - 1], down[N - 1]);
    }
}
```
#### 2. 优化时间复杂度 -- 线性动态规划
数组中的任何元素都对应下面三种可能状态中的一种：
1. 上升的过程，$nums[i] > nums[i-1]$
2. 下降的过程，$nums[i] < nums[i - 1]$
3. 相同的位置，$nums[i] == nums[i - 1]$

则动态规划状态转移方程为：
1. 上升过程
$$
up[i] = down[i - 1] + 1 \\
down[i] = down[i - 1]
$$
2. 下降过程
$$
up[i] = up[i - 1] \\
down[i] = up[i - 1] + 1
$$
3. 相同位置
$$
up[i] = up[i - 1] \\
down[i] = down[i - 1]
$$

```java
    public int wiggleMaxLength(int[] nums) {
        final int N = nums.length;
        if (N <= 1) return N;
        int[] up = new int[N];    
        int[] down = new int[N];  
        for (int i = 1; i < N; i++) {
            if (nums[i - 1] < nums[i]) {
                up[i] = down[i - 1] + 1;
                down[i] = down[i - 1];
            } else if (nums[i - 1] > nums[i]) {
                up[i] = up[i - 1];
                down[i] = up[i - 1] + 1;
            } else {
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        return 1 + Math.max(up[N - 1], down[N - 1]);
    }
```

#### 3. 进一步优化2的空间复杂度
```java
    /**
     * 优化空间复杂度的线性动态规划
     */ 
    public int wiggleMaxLength(int[] nums) {
        final int N = nums.length;
        if (N <= 1) return N;
        int up = 0;
        int down = 0;
        for (int i = 1; i < N; i++) {
            if (nums[i - 1] < nums[i]) {
                up = down + 1;
            } else if (nums[i - 1] > nums[i]) {
                down = up + 1;
            }
        }
        return 1 + Math.max(up, down);
    }
```




## Hard
### 85. Maximal Rectangle -- Hard
一层一层遍历
* `height`: 在当前这个位置，从下往上连续的1的个数（包括这个点）
* `left`: 在当前这个位置，高度为height[j]的满足题意的矩形的左下标。0表示在这个位置不存在满足题意的矩形。 从左到右遍历。
* `right`: 在当前这个位置，高度为height[j]的满足题意的矩形的右下标 + 1。 n表示在这个位置不存在满足题意的矩形。从右到左遍历。

```C++
class Solution {
public:
    int maximalRectangle(vector<vector<char>>& matrix) {
        int m = matrix.size();
        if (m <= 0) return 0;
        int n = matrix[0].size();
        if (n <= 0) return 0;

        vector<int> height(n, 0);
        vector<int> left(n, 0);
        vector<int> right(n, n);
        int res = 0;

        for (int i = 0; i < m; i++) {
            int l = 0, r = n;
            // calculate left(i, j) from left to right
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                    left[j] = max(left[j], l);
                } else {
                    l = j + 1;
                    height[j] = 0;
                    left[j] = 0;
                    right[j] = n;
                }
            }

            // calculate right(i, j) from right to left
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = min(right[j], r);
                    res = max(res, height[j] * (right[j] - left[j]));
                } else {
                    r = j;
                }
            }
        }

        return res;
    }
};
```



### 97. Interleaving String -- Hard
设$dp[i][j]$表示$s1[0...i-1]$和$s2[0...j-1]$匹配$s3[0...i + j + 1]$, 则
$$
dp[i][j] = dp[i - 1][j] \&\& s1[i] == s3[i+j+1] || dp[i][j - 1] \&\& s2[j] == s3[i + j + 1]
$$

### 115. Distinct Subsequences -- Hard
设$dp[i, j]$为$T[0, j]$在$S[0, i]$中出现的次数。
$$
dp[i, j]=\left\{
\begin{aligned}
& dp[i - 1, j], \quad & S[i] \not= T[j] \\
& dp[i - 1, j] + dp[i - 1, j - 1], \quad & S[i]=T[j]
\end{aligned}
\right.
$$

### 123. Best Time to Buy and Sell Stock III -- Hard
能买卖两次，则将数组分为两段，每段只能买卖最多一次。
设$f[i]$表示区间$[0, i]$的买卖最多一次的最大利润，$g[i]$表示区间$[i, n - 1]$的买卖最多一次的最大利润.
$$
res = \max \{f(i) + g(i)\}, \quad 0 \le i \le n - 1
$$

### 132. Palindrome Partitioning II -- Hard
定义$dp[i][j]$表示区间$[i, j]$之间的最小cut数，则状态转移方程为：
$$
dp[i][j] = min(dp[i][k] + dp[k + 1][j] + 1), \quad i \le k \le j, 0 \le i \le j < n
$$ -- **难以实现**

转化为一维DP: $dp[i]$ 表示区间$[i, n - 1]$之间最小的cut数，状态转移方程为：
$$
dp[i] = min(dp[j + 1] + 1), \quad i \le j < n
$$
**其中$[i, j]$为回文串**。判断$[i, j]$是否为回文串：再用一次DP。
$$
P[i][j] = str[i] == str[j] \&\& P[i + 1][j - 1]
$$
