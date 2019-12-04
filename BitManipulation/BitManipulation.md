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