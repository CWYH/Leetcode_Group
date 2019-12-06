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
#### 284. Peeking Iterator* -- Medium
只用Iterator这个类，不要用其他的数据结构。