/**
 * 252. Meeting Rooms -- Easy
 *
 *
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 *
 * Example 1:
 * 
 * Input: [[0,30],[5,10],[15,20]]
 * Output: false
 *
 * Example 2:
 * 
 * Input: [[7,10],[2,4]]
 * Output: true
 *
 */

#include <vector>
#include <algorithm>
using namespace std;

bool myCmp (const vector<int>& v1, const vector<int>& v2) {
	return v1[0] < v2[0];
}

class Solution {
public:
    bool canAttendMeetings(vector<vector<int>>& intervals) {
    	if (intervals.size() <= 1) return true; 
        sort(intervals.begin(), intervals.end(), myCmp);
        for (int i = 0; i < intervals.size() - 1; i++) {
        	if (intervals[i][1] > intervals[i + 1][0]) 
        		return false;
        }

        return true;
    }
};