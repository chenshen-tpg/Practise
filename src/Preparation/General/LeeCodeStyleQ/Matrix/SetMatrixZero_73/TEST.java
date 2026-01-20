package Preparation.General.LeeCodeStyleQ.Matrix.SetMatrixZero_73;

public class TEST {
    public static void main(String[] args) {
//        int[][] matrix = {
//                {0, 1, 2, 0},
//                {3, 4, 5, 2},
//                {1, 3, 1, 5}
//        };
//        int[][] matrix5x5 = {
//                {1, 2, 0, 4, 5},
//                {6, 7, 8, 9, 10},
//                {11, 0, 13, 14, 15},
//                {16, 17, 18, 19, 20},
//                {21, 22, 23, 24, 25}
//        };
        int[][] matrix = {
                {1, 2, 3, 4, 5, 6, 7, 8},
                {9, 1, 2, 3, 4, 5, 6, 0},
                {2, 3, 4, 5, 6, 7, 8, 9},
                {3, 4, 5, 6, 7, 8, 9, 1},
                {4, 5, 6, 7, 0, 9, 1, 2},
                {5, 6, 7, 8, 9, 1, 2, 3},
                {6, 7, 8, 9, 1, 2, 3, 4},
                {7, 8, 9, 1, 2, 3, 4, 5}
        };
        TEST solution = new TEST();
        helper(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
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
