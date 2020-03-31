/**
 * 289. Game of Life -- Medium
 */

class Solution {
    public void gameOfLife(int[][] board) {
        final int M = board.length;
        if (M <= 0) return;
        final int N = board[0].length;
        if (N <= 0) return;

        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int lives = 0;
                for (int k = 0; k < dx.length; k++) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x >= 0 && x < M && y >= 0 && y < N && (board[x][y] == 1 || board[x][y] == -1)) {
                        lives++;
                    }
                }
                if (lives < 2 && board[i][j] == 1) board[i][j] = -1;    // die
                if (lives > 3 && board[i][j] == 1) board[i][j] = -1;    // die 
                if (lives == 3 && board[i][j] == 0) board[i][j] = -2;   // live 
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == -1) board[i][j] = 0;
                if (board[i][j] == -2) board[i][j] = 1;
            }
        }
    }
}
