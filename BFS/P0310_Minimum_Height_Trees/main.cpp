/**
 * 310. Minimum Height Trees -- Medium
 */

// A Tree is a graph with no cycles!

#include <iostream>
#include <vector>
#include <unordered_set>
using namespace std;

class Solution {
public:
    vector<int> findMinHeightTrees(int n, vector<vector<int>>& edges) {
        if (n == 1) return {0};
        vector<unordered_set<int>> adj(n);
        for (int i = 0; i < edges.size(); i++) {
            adj[edges[i][0]].insert(edges[i][1]);
            adj[edges[i][1]].insert(edges[i][0]);
        }
        unordered_set<int> leaves;
        for (int i = 0; i < n; i++) {
            if (adj[i].size() == 1) leaves.insert(i);  // 度为1的节点为叶子节点
        }
        while (n > 2) {
            n -= leaves.size();
            unordered_set<int> tmpLeaves;
            for (auto it = leaves.begin(); it != leaves.end(); it++) {
                int u = *it;
                int v = *adj[u].begin();
                adj[v].erase(u);
                if (adj[v].size() == 1) tmpLeaves.insert(v);
            }
            swap(leaves, tmpLeaves);
        }
        vector<int> res;
        for (auto it = leaves.begin(); it != leaves.end(); it++)
            res.push_back(*it);
        return res;
    }
};

int main() {
    Solution s;
    int n = 8;
    vector<vector<int>> edges = {{0,1},{1,2},{2,3},{0,4},{4,5},{4,6},{6,7}};
    vector<int> res = s.findMinHeightTrees(n, edges);
    for (int i = 0; i < res.size(); i++) {
        printf("%d\n", res[i]);
    }
    return 0;
}
