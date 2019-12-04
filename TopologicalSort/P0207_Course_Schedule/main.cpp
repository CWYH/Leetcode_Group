/**
 * 207. Course Sechedule -- Medium
 *
 * Topological Sort to detect Cycle. -- BFS
 */

#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        if (numCourses <= 1) return true;
        queue<int> q;
        vector<int> inDegree(numCourses, 0);
        vector<vector<int>> G(numCourses);
        for (int i = 0; i < prerequisites.size(); i++) {
            G[prerequisites[i][1]].push_back(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                q.push(i);
        }
        
        int n = 0;
        while (!q.empty()) {
            int t = q.front();
            q.pop();
            n++;
            for (int node : G[t]) {
                inDegree[node]--;
                if (inDegree[node] == 0) {
                    q.push(node);
                }
            }
        }
        
        return n == numCourses;
    }
};

int main() {
    Solution s;
    int numCourses = 2;
    vector<vector<int>> prerequisites = {{1, 0}}; // {{1, 0}, {0, 1}};
    printf("%d\n", s.canFinish(numCourses, prerequisites));
    return 0;
}