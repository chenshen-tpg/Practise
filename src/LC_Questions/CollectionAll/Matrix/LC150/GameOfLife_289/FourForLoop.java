package LC_Questions.CollectionAll.Matrix.LC150.GameOfLife_289;

public class FourForLoop {
    public static void main(String[] args) {
        int[][] board3 = {
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {0, 0, 1, 1},
                {0, 0, 1, 1}
        };
        gameOfLife(board3);
    }
    public static void gameOfLife(int[][] b) {
        int row = b.length;
        int col = b[0].length;
        int[][] board = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = b[i][j];
            }
        }
        int[] cord = {-1, 0, 1};

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int count = 0;
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (!(cord[k] == 0 && cord[l] == 0)) {
                            int r = i + cord[k];
                            int c = j + cord[l];
                            if (r >= 0 && r < row && c >= 0 && c < col && board[r][c] == 1) count++;
                        }
                    }
                }
                if (board[i][j] == 1 && (count < 2 || count > 3)) b[i][j] = 0;
                else if (board[i][j] == 0 && count == 3) b[i][j] = 1;
            }
        }
    }
}
