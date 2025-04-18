package LC_Questions.Graph.Matrix.PremiumAlgo100.CandyCrush_723;

public class BoardDropper {
    private int m;
    private int n;

    public BoardDropper(int m, int n) {
        this.m = m;
        this.n = n;
    }
    public static void main(String[] args) {
        int[][] gameBoard = {
                {1, 0, 2, 0},
                {0, 3, 0, 4},
                {5, 0, 6, 0},
                {0, 7, 0, 8}
        };

        int rows = gameBoard.length;
        int cols = gameBoard[0].length;
        BoardDropper dropper = new BoardDropper(rows, cols);
        System.out.println("Original Board:");
        printBoard(gameBoard);
        dropper.drop(gameBoard);
        System.out.println("\nBoard After Drop:");
        printBoard(gameBoard);
    }
    public void drop(int[][] board) {
        for (int c = 0; c < n; c++) {
            int lowestZero = -1;
            for (int r = m - 1; r >= 0; r--) {
                if (board[r][c] == 0) {
                    lowestZero = Math.max(lowestZero, r);
                } else if (lowestZero >= 0) {
                    int temp = board[r][c];
                    board[r][c] = board[lowestZero][c];
                    board[lowestZero][c] = temp;
                    lowestZero--;
                }
            }
        }
    }



    private static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
