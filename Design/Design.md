# Design

## Leetcode

### Easy

#### 716. *** Max Stack -- Easy  

* 方法一：双栈

* 方法二：双向链表 + 平衡树 -- 时间复杂度$O(\log n)$
  双向链表:  `list`
  平衡树(红黑树):  ` map `

  ```c++
  #include <iostream>
  #include <list>
  #include <map>
  using namespace std;
  
  class MaxStack {
  public:
  	/** initialize your data structure here. */
  	MaxStack() {
  	}
  
  	void push(int x) {
  		stkList.push_front(x);
  		stkMap[x].push_front(stkList.begin());
  	}
  
  	int pop() {
  		int t = top();
  		stkList.pop_front();
  		stkMap[t].pop_front();
  		if (stkMap[t].size() == 0) {  // the list of stkMap[t] is empty and shoud be erased
  			stkMap.erase(t);
  		}
  		return t;
  	}
  
  	int top() {
  		return *stkList.begin();
  	}
  
  	int peekMax() {
  		auto it = stkMap.end();
  		it--;   // point to the last element
  		return it->first;
  	}
  
  	int popMax() {
  		int m = peekMax();
  		map<int, list<list<int>::iterator>>::iterator mapLastIt = stkMap.end();
  		mapLastIt--;
  		list<int>::iterator maxIt = *mapLastIt->second.begin();
  		mapLastIt->second.pop_front();
  		if (mapLastIt->second.size() == 0) {   // the list in stkMap is empty and shoud be erased
  			stkMap.erase(mapLastIt);
  		}
  		stkList.erase(maxIt);
  		return m;
  	}
  
  
  private:
  	list<int> stkList;
  	map<int, list<list<int>::iterator>> stkMap;
  };
  
  ```
  
  
### Medium

#### 211. Add and Search Word - Data structure design -- Medium
Trie的应用 

#### 271. Encode and Decode Strings* -- Medium
Serialization.
see `protobuf`.

对于每个字符串，记录下串的长度。

#### 281. Zig-Zag Iterator -- Medium
Easy

#### 284. Peeking Iterator* -- Medium
只用Iterator这个类，不要用其他的数据结构。

#### 288. 288. Unique Word Abbreviation -- Medium
傻逼问题

#### 348. Design Tic-Tac-Toe -- Medium
只保存行/列/对角线的和，而不用保存所有元素。
空间复杂度$O(N)$。
每次`move`， 时间复杂度$O(1)$。

#### 353. Design Snake Game -- Medium
判断的关键点在于，先移除蛇的尾部，再判断蛇头会不会撞到

#### 355. Design Twitter******* -- Medium
OOP + k个排序链表合并问题
https://leetcode-cn.com/problems/design-twitter/solution/mian-xiang-dui-xiang-she-ji-he-bing-k-ge-you-xu-li/

#### 380. Insert Delete GetRandom O(1) * -- Medium
线性表`ArrayList` + 哈希表

注意：删除任意索引元素需要时间$O(1)$，这里的解决方案是总是删除最后一个元素。
* 将要删除元素和最后一个元素交换。
* 将最后一个元素删除。

#### 381. Insert Delete GetRandom O(1) - Duplicates allowed *** -- Hard
同380.

注意删除操作。list的最后一个数为val则直接删除最后一个数。

#### 384. Shuffle an Array -- Medium
Fisher-Yates 洗牌算法 


### Hard

#### 432. All O`one Data Structure ***** -- Hard
双向链表 + 两个Hash表
```java
    private class Node {
        int val;
        HashSet<String> keys;
        Node pre;
        Node next;
	}
	
    private HashMap<String, Node> keyMap;   // key -> Node
    private HashMap<Integer, Node> valMap;  // val -> Node
```

注意`inc`实现时，当当前链表中没有对应`key`时，检查当前链表是否有`val`为1的节点，有则直接在该节点上添加`key`，没有再插入新的节点。