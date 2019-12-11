/**
 * 463. Island Perimeter -- Easy
 */

class Solution {
    public int islandPerimeter(int[][] grid) {
        int res = 0;
        final int M = grid.length;
        final int N = grid[0].length;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int x, y;
        for (int i = 0; i < M; i++) {
        	for (int j = 0; j < N; j++) {
        		if (grid[i][j] == 1) {
        			for (int k = 0; k < 4; k++) {
        				x = i + dx[k];
        				y = j + dy[k];
        				if (x >= 0 && x < M && y >= 0 && y < N) {
        					if (grid[x][y] == 0) res++;
        				} else {
        					res++;
        				}
        			}
        		}
        	}
        }
        return res;
    }
}