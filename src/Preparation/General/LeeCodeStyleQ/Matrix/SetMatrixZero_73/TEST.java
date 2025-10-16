package Preparation.General.LeeCodeStyleQ.Matrix.SetMatrixZero_73;

public class TEST {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
    }

    public static void helper(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean firstr = false, firstc = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        firstr = true;
                    }
                    if (j == 0) {
                        firstc = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (firstr) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        if (firstc) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }


}
