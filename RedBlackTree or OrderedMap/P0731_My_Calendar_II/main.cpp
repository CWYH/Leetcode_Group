/**
 * 731. My Calendar II -- Medium
 *
 * Microsoft, Google
 */

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


/**
 * 维护一重预定区间和两重预定区间
 */

class MyCalendarTwo {
private:
	vector<pair<int, int>> single;
	vector<pair<int, int>> twice;
public:
    MyCalendarTwo() {
        
    }
    
    bool book(int start, int end) {
    	// check the twice map, if overlapping return false
    	for (auto it = twice.begin(); it != twice.end(); it++) {
    		if (it->first < end && start < it->second) 
    			return false;
    	}

        // insert new booking to single map and update the twice map
        for (auto it = single.begin(); it != single.end(); it++) {
        	if (it->first < end && start < it->second) {
        		twice.push_back(make_pair(max(it->first, start), min(it->second, end)));
        	}
        }
        single.push_back(make_pair(start, end));
        return true;
    }
};

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo* obj = new MyCalendarTwo();
 * bool param_1 = obj->book(start,end);
 */