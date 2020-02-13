# HashMap

## Leetcode

### Easy

#### 389. Find the Difference***
除了使用HashMap， 还可以使用位运算（异或运算）。

#### 409. Longest Palindrome*
最长回文串长度 = 偶数个字母的长度之和 + （奇数个字母的长度-1）之和
如果存在奇数个字母，总长度再+1.

#### 447. Number of Boomerangs***
对于每个$i$遍历整个数组，HashMap保存$i$到$j$的距离(平方)的个数。这样对于HashMap的每个键值对`key:val`, 必然有`val * (val - 1)`种满足条件的可能。

注意每轮循环后要清空HashMap。

`需要重写hashCode()和equals()方法才可以实现自定义键在HashMap中的查找。`



#### 500. KeyBoard Row
Java中`List`转数组，数组转`List`:
```java
//list转数组
List<String> myList = new ArrayList<String>();
String[] PFIdArr = myList.toArray(new String[myList.size()]);


//数组转list
String[] s = {"a","b","c"};
List list = java.util.Arrays.asList(s);
```

### Medium

#### 325. Maximum Size Subarray Sum Equaks k
HashMap, key为当前前缀和，val为第一次出现该前缀和的下标。
一次遍历，时间复杂度$O(N)$。

#### 560. Subarray Sum Equals K***** -- Medium
遍历时用Hash表存储 和S[i]出现的次数