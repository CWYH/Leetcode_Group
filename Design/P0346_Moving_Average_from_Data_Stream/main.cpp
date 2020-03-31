/**
 * 346. Moving Average from Data Stream -- Easy
 * 
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 * Example:
 *     MovingAverage m = new MovingAverage(3)
 *     m.next(1) = 
 *     m.next(10) = (1 + 10) / 2
 *     m.next(3) = (1 + 10 + 3) / 3
 *     m.next(5) = (10 + 3 + 5) / 3
 */ 

#include <queue>
using namespace std;

class MovingAverage {
public:
    /** Initialize your data structure here. */
    MovingAverage(int size) {
        this->cap = size;
        this->ma = 0.0;
    }
    
    double next(int val) {
        q.push(val);
        if (q.size() <= cap) {
            ma = (ma * (q.size() - 1) + val) / q.size();
        } else {
            int last = q.front();
            q.pop();
            ma = (ma * cap - last + val) / cap;
        }
        return ma;
    }

private:
    queue<int> q;
    int cap;
    double ma;
};

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage* obj = new MovingAverage(size);
 * double param_1 = obj->next(val);
 */