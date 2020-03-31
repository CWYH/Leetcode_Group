/**
 * 419. Battleships in a Board
 */

class Solution {
    public int countBattleships(char[][] board) {
        final int M = board.length;
        if (M <= 0) return 0;
        final int N = board[0].length;
        if (N <= 0) return 0;

        int res = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'X') {
                    if (i > 0 && board[i - 1][j] == 'X') continue;
                    if (j > 0 && board[i][j - 1] == 'X') continue;
                    res++;
                }
            }
        }
        return res;
    }
}