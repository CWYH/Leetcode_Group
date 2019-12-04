/**
 * 253. Meeting Rooms II -- Medium
 *
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
 * find the minimum number of conference rooms required.
 *
 * Example 1:
 * 
 *   Input: [[0, 30],[5, 10],[15, 20]]
 *   Output: 2
 * 
 * Example 2:
 * 
 *   Input: [[7,10],[2,4]]
 *   Output: 1
 *
 */

//
// 算法 -- 优先队列
// 我们可以将所有房间保存在最小堆中, 堆中的键值是会议的结束时间，而不用手动迭代已分配的每个房间并检查房间是否可用。
// 
// 1. 按照 开始时间 对会议进行排序。
// 2. 初始化一个新的 最小堆，将第一个会议的结束时间加入到堆中。我们只需要记录会议的结束时间，告诉我们什么时候房间会空。
// 3. 对每个会议，检查堆的最小元素（即堆顶部的房间）是否空闲。
//    * 若房间空闲，则从堆顶拿出该元素，将其改为我们处理的会议的结束时间，加回到堆中。
//    * 若房间不空闲。开新房间，并加入到堆中。
// 4. 处理完所有会议后，堆的大小即为开的房间数量。这就是容纳这些会议需要的最小房间数。
//

#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

bool CMP (const vector<int> & v1, const vector<int> & v2) {
    return v1[0] < v2[0];
}

struct minpqCmp {
    bool operator () (const int & a, const int & b) {
        return a > b;
    }
};

class Solution {
public:
    int minMeetingRooms(vector<vector<int>>& intervals) {
        if (intervals.size() == 0) return 0;

        sort(intervals.begin(), intervals.end(), CMP);   // sort according to the start time
        
        priority_queue<int, vector<int>, minpqCmp> pq;
        pq.push(intervals[0][1]);

        for (int i = 1; i < intervals.size(); i++) {
            int t = pq.top();
            if (intervals[i][0] >= t) {
                pq.pop();
            }
            pq.push(intervals[i][1]);
        }

        return pq.size();
    }
};