package LC_Questions.OOP.PremiumAlgo100.DesignTicTacToe_348;

public class TEST {
    int [][] memo;
    int len;

    public TEST(int n) {
        memo = new int [n][n];
        len = n;
    }

    public int move(int row, int col, int player) {
        memo[row][col] = player;
        if ( checkRow(row, player) ||
                checkCol(col, player) ||
                (row == col && checkDiag(player)) ||
                (col == len - row - 1 && checkAnti(player))) return player;
        return 0;
    }
    public boolean checkRow(int row, int player) {
        for (int col = 0; col < len; col++) {
            if (memo[row][col] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkCol(int col, int player) {
        for (int row = 0; row < len; row++) {
            if (memo[row][col] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiag(int player) {
        for (int row = 0; row < len; row++) {
            if (memo[row][row] != player) {
                return false;
            }
        }
        return true;
    }

    private boolean checkAnti(int player) {
        for (int row = 0; row < len; row++) {
            if (memo[row][len - row - 1] != player) {
                return false;
            }
        }
        return true;
    }
}
