/**
 * 79. Word Search -- Medium
 */ 

#include <vector>
#include <string>
using namespace std;

class Solution {
public:
    bool exist(vector<vector<char>>& board, string word) {
        if (word.size() == 0) return false;
        const int m = board.size();
        const int n = board[0].size();
        for (int i = 0; i != m; i++) {
            for (int j = 0; j != n; j++) {
                if (board[i][j] == word[0]) {
                    vector<vector<bool>> vis(m, vector<bool>(n, false));
                    vis[i][j] = true;
                    bool r = dfs(board, word, 0, i, j, vis);
                    if (r) return r;
                }
            }
        }
        return false;
    }

    bool dfs(vector<vector<char>>& board, string word, int idx, int i, int j, vector<vector<bool>>& vis) {
        if (idx == word.size() - 1) return true;
        bool r = false;
        if (i > 0 && !vis[i - 1][j] && word[idx + 1] == board[i - 1][j]) {
            vis[i - 1][j] = true;
            r = dfs(board, word, idx + 1, i - 1, j, vis);
            vis[i - 1][j] = false;
            if (r) return true;
        }

        if (i + 1 < board.size() && !vis[i + 1][j] && word[idx + 1] == board[i + 1][j]) {
            vis[i + 1][j] = true;
            r = dfs(board, word, idx + 1, i + 1, j, vis);
            vis[i + 1][j] = false;
            if (r) return true;
        }

        if (j > 0 && !vis[i][j - 1] && word[idx + 1] == board[i][j - 1]) {
            vis[i][j - 1] = true;
            r = dfs(board, word, idx + 1, i, j - 1, vis);
            vis[i][j - 1] = false;
            if (r) return true;
        }

        if (j + 1 < board[0].size() && !vis[i][j + 1] && word[idx + 1] == board[i][j + 1]) {
            vis[i][j + 1] = true;
            r = dfs(board, word, idx + 1, i, j + 1, vis);
            vis[i][j + 1] = false;
            if (r) return true;
        }

        return false;
    }
};