/**
 * 348. Design Tic-Tac-Toe -- Medium
 * 
 * Microsoft
 */

class TicTacToe {

    class Record {
        int n;
        int[] row;
        int[] col;
        int diagLeft;
        int diagRight;
        Record() {}
        Record(int n) {
            this.n = n;
            row = new int[n];
            col = new int[n];
            diagLeft = 0;
            diagRight = 0;
        }
    }

    private int n;
    private Record[] Rec;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.n = n;
        Rec = new Record[2];
        Rec[0] = new Record(n);
        Rec[1] = new Record(n);
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        Rec[player - 1].row[row]++;
        Rec[player - 1].col[col]++;
        if (row == col) {
            Rec[player - 1].diagLeft++;
        }
        if (row + col == n - 1) {
            Rec[player - 1].diagRight++;
        }

        if (Rec[player - 1].row[row] == n || Rec[player - 1].col[col] == n 
        || Rec[player - 1].diagLeft == n || Rec[player - 1].diagRight == n) {
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */