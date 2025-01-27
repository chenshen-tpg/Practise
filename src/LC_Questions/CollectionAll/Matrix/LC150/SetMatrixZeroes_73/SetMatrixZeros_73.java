package LC_Questions.CollectionAll.Matrix.LC150.SetMatrixZeroes_73;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeros_73 {
    public static void main(String[] args) {
        SetMatrixZeros_73 sm = new SetMatrixZeros_73();
        int[][] matrix = new int[][]{{1,2,3},{4,0,6},{7,8,9}};
        sm.setZeroes(matrix);
    }

    private void setZeroes(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]==0) {
                     mark(matrix, i, j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            System.out.println();
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
        }
    }

    private void mark(int[][] matrix, int i, int j) {
        for (int k = 0; k < matrix.length; k++) {
            if (matrix[k][j] != 0) {
                matrix[k][j] = -1;
            }
        }
        for (int k = 0; k < matrix[i].length; k++) {
            if (matrix[i][k] != 0) {
                matrix[i][k] = -1;
            }
        }
    }
    public void correctAns(int[][] matrix) {
        Set<Integer> rows = new HashSet<Integer>();
        Set<Integer> cols = new HashSet<Integer>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]==0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j]=0;
                }
            }
        }
    }
}
