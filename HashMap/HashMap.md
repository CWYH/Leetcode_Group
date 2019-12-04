# HashMap

## Leetcode

### Easy

#### 389. Find the Difference***
除了使用HashMap， 还可以使用位运算（异或运算）。

#### 409. Longest Palindrome*
最长回文串长度 = 偶数个字母的长度之和 + （奇数个字母的长度-1）之和
如果存在奇数个字母，总长度再+1.

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