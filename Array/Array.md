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
#### 161. One Edit Distance -- Medium
一次遍历，时间复杂度$O(N)$.
```java
    public boolean isOneEditDistance(String s, String t) {
        final int M = s.length();
        final int N = t.length();
        if (M > N) return isOneEditDistance(t, s);
        if (N - M > 1) return false;
        
        for (int i = 0; i < M; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (M == N) return s.substring(i + 1).equals(t.substring(i + 1));
                else return s.substring(i).equals(t.substring(i + 1));
            }
        }
        return M == N - 1;
    }
```

#### 163. Missing Ranges -- Medium
在nums中加入`lower-1`和`upper+1`.

使用`long`类型，防止`Integer.MIN_VALUE`和`Integer.MAX_VALUE`的问题。


#### 229. Majority Element II ***
Bayor-Moore Algorithm
两次遍历，对于最多有$k$个可能的majority element, 时间复杂度$O(kN)$, 空间复杂度$O(k)$. 对于本题，$\lfloor n/3 \rfloor$表明最多有$k=2$种majority emelent的可能.
* 第一次遍历：找到$k$种可能数(candidates)
* 第二次遍历：检验每个candidate的个数是否满足条件.


[https://leetcode.com/problems/majority-element-ii/discuss/63520/Boyer-Moore-Majority-Vote-algorithm-and-my-elaboration]

[https://gregable.com/2013/10/majority-vote-algorithm-find-majority.html]

#### 289. Game of Life
使用负数标记要变化的格子，可以做到$O(1)$的空间复杂度。


### Hard

#### 41. First Missing Positive*** -- Hard
Put each number in its right place.
For example: When we find 5, then swap it with A[4].
At last, the first place where its number is not right, return the place + 1.