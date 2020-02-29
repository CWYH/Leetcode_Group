import java.util.*;

/**
 * 351. Android Unlock Patterns -- Medium
 */

class Solution {
    private int sum = 0;
    private int m = 0;
    private int n = 0;

    public int numberOfPatterns(int m, int n) {
        if (m <= 0 || n <= 0 || m > n) return 0;
        this.m = m;
        this.n = n;
        boolean[][] vis = new boolean[3][3];
        for (int i = 0; i < 3; i++) Arrays.fill(vis[i], false);

        int res = 0;
        sum = 0;
        dfs(vis, 0, 0, 1);
        res += sum * 4;
        sum = 0;
        dfs(vis, 0, 1, 1);
        res += sum * 4;
        sum = 0;
        dfs(vis, 1, 1, 1);
        res += sum;
        return res;
    }

    private void dfs(boolean[][] vis, int curi, int curj, int k) {
        if (k > n) return;
        if (k >= m) sum++;
        vis[curi][curj] = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i < 0 || i >= 3 || j < 0 || j >= 3) continue;
                if (i == curi && j == curj) continue;
                if (vis[i][j]) continue;
                if (i == curi && j + curj == 2 && !vis[i][1]) continue;
                if (j == curj && i + curi == 2 && !vis[1][j]) continue;
                if (i + curi == 2 && j + curj == 2 && !vis[1][1]) continue;
                dfs(vis, i, j, k + 1);
            }
        }
        vis[curi][curj] = false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int m = 1;
        int n = 9;
        System.out.print(s.numberOfPatterns(m, n));
    }
}