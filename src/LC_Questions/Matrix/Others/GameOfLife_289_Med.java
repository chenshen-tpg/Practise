package LC_Questions.Matrix.Others;

public class GameOfLife_289_Med {
    public static void main(String[] args) {
        GameOfLife_289_Med g = new GameOfLife_289_Med();
        int[][] board = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        g.gameOfLife(board);
        for (int[] ints : board) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public void gameOfLife(int[][] b) {
        int[] cord = {-1, 0, 1};
        int row = b.length;
        int col = b[0].length;
        int[][] board = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = b[i][j];
            }
        }
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
                if (board[i][j] == 0 && count == 3) b[i][j] = 1;
            }
        }
    }
}
