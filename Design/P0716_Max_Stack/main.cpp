/**
 * 716. Max Stack -- Easy
 *
 * Design a max stack that supports push, pop, top, peekMax and popMax.
 *     1. push(x) -- Push element x onto stack.
 *     2. pop() -- Remove the element on top of the stack and return it.
 *     3. top() -- Get the element on the top.
 *     4. peekMax() -- Retrieve the maximum element in the stack.
 *     5. popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more
 *                    than one maximum elements, only remove the top-most one.
 * Example 1:
 *     MaxStack stack = new MaxStack();
 *     stack.push(5);
 *     stack.push(1);
 *     stack.push(5);
 *     stack.top(); -> 5
 *     stack.popMax(); -> 5
 *     stack.top(); -> 1
 *     stack.peekMax(); -> 5
 *     stack.pop(); -> 1
 *     stack.top(); -> 5
 * Note:
 *     1. -1e7 <= x <= 1e7
 *     2. Number of operations won't exceed 10000.
 *     3. The last four operations won't be called when stack is empty.
 */

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

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack* obj = new MaxStack();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->peekMax();
 * int param_5 = obj->popMax();
 */

int main() {
	MaxStack stack;
	stack.push(5);
	stack.push(1);
	stack.push(6);
	cout << stack.peekMax() << endl;
	cout << stack.popMax() << endl;
	cout << stack.popMax() << endl;
	cout << stack.top() << endl;
	//cout << stack.top()    << endl; // -> 5
	//cout << stack.popMax() << endl; // -> 5
	//cout << stack.top()    << endl; // -> 1
	//cout << stack.peekMax()<< endl; // -> 5
	//cout << stack.pop()    << endl; // -> 1
	//cout << stack.top()    << endl; // -> 5
	return 0;
}