/**
 * 210. Course Sechedule II -- Medium
 *
 * Topological Sort.
 */

#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        vector<vector<int>> G(numCourses);
        priority_queue<int, vector<int>, less<int>> q;
        vector<int> inDegree(numCourses, 0);
        for (int i = 0; i < prerequisites.size(); i++) {
            G[prerequisites[i][1]].push_back(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) q.push(i);
        }
        
        vector<int> res;
        while (!q.empty()) {
            int t = q.top();
            q.pop();
            res.push_back(t);
            for (int node : G[t]) {
                inDegree[node]--;
                if (inDegree[node] == 0) q.push(node);
            }
        }
        
        if (res.size() < numCourses) return vector<int>();
        return res;
    }
};
