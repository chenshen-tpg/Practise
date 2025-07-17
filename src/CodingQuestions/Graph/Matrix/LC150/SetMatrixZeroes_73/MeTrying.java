package CodingQuestions.Graph.Matrix.LC150.SetMatrixZeroes_73;

import java.util.Arrays;

public class MeTrying {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        MeTrying solution = new MeTrying();
        solution.setZeroes(matrix);
        System.out.println("Resulting matrix: " + Arrays.deepToString(matrix));
    }

    private void setZeroes(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < matrix[0].length; k++) {
                        if (matrix[i][k] != 0) matrix[i][k] = -99;
                    }
                    for (int l = 0; l < matrix.length; l++) {
                        if (matrix[l][j] != 0) matrix[l][j] = -99;
                    }
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == -1) matrix[i][j] = 0;
            }
        }
    }
}
