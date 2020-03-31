#include <iostream>
#include <list>
#include <unordered_map>
using namespace std;

struct cacheNode {
	int key;
	int val;
	cacheNode(int k, int v) : key(k), val(v) {}
};

class LRUCache {
public:
	LRUCache(int capacity) {
		this->capacity = capacity;
	}

	int get(int key) {
		if (cacheMap.find(key) == cacheMap.end()) return -1;
		list<cacheNode>::iterator it = cacheMap[key];
		int val = it->val;
		cacheList.erase(it);
		cacheList.push_front(cacheNode(key, val));
		cacheMap[key] = cacheList.begin();

		return val;
	}

	void put(int key, int value) {
		if (cacheMap.find(key) != cacheMap.end()) { // the key exists
			list<cacheNode>::iterator it = cacheMap[key];
			cacheList.erase(it);
			cacheList.push_front(cacheNode(key, value));
			cacheMap[key] = cacheList.begin();
		}
		else {  // the key does not exist
			cacheList.push_front(cacheNode(key, value));
			cacheMap[key] = cacheList.begin();

			if (cacheList.size() > capacity) {
				cacheMap.erase(cacheList.back().key);
				cacheList.pop_back();
			}
		}
	}

private:
	int capacity;
	list<cacheNode> cacheList;
	unordered_map<int, list<cacheNode>::iterator> cacheMap;
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */

int main() {
	LRUCache lru(1);
	lru.put(2, 1);
	cout << lru.get(2) << endl;
	lru.put(3, 2);
	cout << lru.get(2) << endl;
	cout << lru.get(3) << endl;
	return 0;
}