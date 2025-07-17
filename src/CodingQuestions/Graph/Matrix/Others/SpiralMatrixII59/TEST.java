package CodingQuestions.Graph.Matrix.Others.SpiralMatrixII59;

public class TEST {
    public static void main(String[] args) {
        int [][] test = {{1,2,3},{8,9,4},{7,6,5}};
        int fullLen = 3 * 3, n = 3;
        while (fullLen > 0) {
            for (int i = 0; i < n; i++) {

            }
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int cnt = 1;
        for (int row = 0; row < (n + 1) / 2; row++) {
            for (int ptr = row; ptr < n - row; ptr++) {
                result[row][ptr] = cnt++;
            }
            for (int ptr = row + 1; ptr < n - row; ptr++) {
                result[ptr][n - row - 1] = cnt++;
            }
            for (int ptr = row + 1; ptr < n - row; ptr++) {
                result[n - row - 1][n - ptr - 1] = cnt++;
            }
            for (int ptr = row + 1; ptr < n - row - 1; ptr++) {
                result[n - ptr - 1][row] = cnt++;
            }
        }
        return result;
    }
}
