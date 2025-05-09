package LC_Questions.Graph.Matrix.Others.GameOfLife_289;

public class CopyWithCoordinates {
    public static void main(String[] args) {
        CopyWithCoordinates g = new CopyWithCoordinates();
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
                if (board[i][j] == 0 && count == 3) b[i][j] = 1;
            }
        }
    }
    public void gameOfLifeOneLoop(int[][] board) {
        int [][] copy = new int[board.length][board[0].length];
        int [][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {-1, 1}, {-1, -1}, {1, 1},{1, -1}};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                copy[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int countOne = 0;
                for (int k = 0; k < dir.length; k++) {
                    int row = i + dir[k][0], col = j + dir[k][1];
                    if (col >= 0 && col < board[i].length && row >= 0 && row < board.length && copy[row][col] == 1) {
                        countOne++;
                    }
                }
                if (copy[i][j] == 1 && (countOne < 2 || countOne > 3 )) board[i][j] = 0;
                if (copy[i][j] == 0 && countOne == 3) board[i][j] = 1;
            }
        }
    }
}
