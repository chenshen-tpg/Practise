package LC_Questions.CollectionAll.Matrix.LC150.SetMatrixZeroes_73;

import java.util.HashSet;
import java.util.Set;

public class TwoHashSet {
    public static void main(String[] args) {

    }
    public void setZeroes(int[][] matrix) {
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
