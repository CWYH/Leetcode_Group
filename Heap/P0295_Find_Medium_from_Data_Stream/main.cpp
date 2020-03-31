/**
 * 295. Find Medium from Data Stream -- Hard
 */ 

//
// Two priority queues:
//     A max-heap loPQ to store the smaller half of the numbers
//     A min-heap hiPQ to store the larger half of the numbers
// 
// Keep loPQ.size() >= hiPQ.size()
//     if k = 2 * n + 1, loPQ.size() == n + 1, hiPQ.size() == n
//     if k = 2 * n, loPQ.size() == n, hiPQ.size() == n
// 
// When adding a number num, we need to keep the two-heap property:
//     1. Adding num to loPQ
//     2. Remove the top of loPQ and offer it to hiPQ
//     3. if now loPQ.size() < hiPQ.size(), remove the top of hiPQ and offer it to loPQ
// 
// Note:
//     if loPQ.size() == hiPQ.size(), when adding a num, than the balacing step 3 is needed.
//

#include <algorithm>
#include <queue>
#include <vector>
using namespace std;

struct minHeapCmp {
    bool operator() (const int & a, const int & b) {
        return a > b; 
    }
};

struct maxHeapCmp {
    bool operator() (const int & a, const int & b) {
        return a < b; 
    }
};



class MedianFinder {
public:
    /** initialize your data structure here. */
    MedianFinder() {
    }
    
    void addNum(int num) {
        loPQ.push(num);
        
        hiPQ.push(loPQ.top());
        loPQ.pop();

        if (loPQ.size() < hiPQ.size()) {
            loPQ.push(hiPQ.top());
            hiPQ.pop();
        }
    }
    
    double findMedian() {
        return loPQ.size() == hiPQ.size() ? (loPQ.top() + hiPQ.top()) * 0.5 : loPQ.top();
    }

private:
    priority_queue<int, vector<int>, minHeapCmp> loPQ;   // store the larger half of the numbers
    priority_queue<int, vector<int>, maxHeapCmp> hiPQ;   // store the smaller half of the numbers
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */