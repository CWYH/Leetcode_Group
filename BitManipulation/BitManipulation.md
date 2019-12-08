# Bit Manipulation 神奇的位运算
## Leetcode
### Easy
#### 389. Find the Difference
使用异或。
```java
class Solution {
    public char findTheDifference(String s, String t) {
        char c = t.charAt(t.length() - 1);
        for (int i = 0; i < s.length(); i++) {
            c ^= s.charAt(i);
            c ^= t.charAt(i);
        }
        return c;
    }
}
``` 

#### 476. Number Complement
给定正整数$n$, 我们要找到$k$满足：
$$
2^k \le n < 2^{k+1}
$$
这样，结果就是$2^{k+1}-1-n$.

### Medium
#### 260. Single Number III ***** -- Medium
利用异或运算，两次遍历，时间复杂度$O(N)$.
假设两个只出现一次的数分别是a, b.
1. 第一次异或遍历，得到的结果是 $x=a \oplus b$
2. 根据$x=a\oplus b$, x的二进制表达式中，为1的为表示该位为a和b不同的位，为0的表示该位为a和b相同的位。假设x在第bit_i位上为1，那么所有的数在bit_i位上为1的分为一组，为0的分为另一组，a和b一定分别在这两个组中，每个组里就只有一个只出现一次的数字。对这两个组进行异或运算遍历，就可以得到a和b.
3. 怎么找第bit_i位呢？我们利用lowbit函数。lowbit(s)为s的二进制表达式中最右边的1所对应的值. 因此lowbit(s)二进制表达式中只有一个bit 1.

```
lowbit(s) = s & -s

例如: s=1010

lowbit(s) = 1010 & 0110 = 0010 = 2
表示1010的最右侧1对应的值为二进制10.
```
这样我们得到
```
diff=x & (-x)
```
4. 那么，对数组中每个数num来说:
```
if num & diff == 1:
    num在第一组
else
    num在第二组
```
就分成了两组数，a和b各在一组。

代码如下:
Java
```java
class Solution {
    public int[] singleNumber(int[] nums) {
        int x = 0;
        for (int num : nums) {
            x = x ^ num;
        }

        int diff = lowbit(x);

        int[] res = {0, 0};
        for (int num : nums) {
            if ((num & diff) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }

        return res;
    }

    /**
     * lowbit(x)为x的二进制表达式中最右边的1所对应的值.
     * 因此lowbit(x)二进制表达式中只有一个bit 1.
     *
     * 例如: x=1010
     *
     * lowbit(x) = 1010 & 0110 = 0010 = 2
     */
    private int lowbit(int x) {
        return x & (-x);   // also can be x & (~x + 1) -- 2's Complement
    }
}
```