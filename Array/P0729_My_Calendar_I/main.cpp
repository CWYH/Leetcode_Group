/**
 * 729. My Calendar I -- Medium
 * 
 * Microsoft, Google
 */ 

#include <vector>
#include <map>
using namespace std;

// class MyCalendar {
// public:
//     MyCalendar() {
        
//     }
    
//     bool book(int start, int end) {
//         int pos = binarySearch(start);
//         if (end >= calendar[pos][0]) return false;
//         if (pos > 0 && calendar[pos - 1][1] > start) return false;
//         calendar.insert(calendar.begin() + pos, vector<int>({start, end}));
//         return true;
//     }

//     int binarySearch(int start) {
//         int lo = 0;
//         int hi = calendar.size() - 1;
//         int mid = 0;
//         while (lo <= hi) {
//             mid = lo + (hi - lo) / 2;
//             if (start < calendar[mid][0]) {
//                 hi = mid - 1;
//             } else if (calendar[mid][0] < start) {
//                 lo = mid + 1;
//             } else {
//                 return mid;
//             }
//         }
//         return lo;
//     }

// private:
//     vector<vector<int>> calendar;
// };

class MyCalendar {
public:
    MyCalendar() {
        
    }
    
    bool book(int start, int end) {
        map<int, int>::iterator pos = calendar.lower_bound(start);
        if (pos != calendar.end() && pos->first < end) return false;
        if (pos != calendar.begin() && (--pos)->second > start) return false;
        calendar[start] = end;
        return true;
    }

private:
    map<int, int> calendar;
};


/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar* obj = new MyCalendar();
 * bool param_1 = obj->book(start,end);
 */