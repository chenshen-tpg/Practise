package LC_Questions.Matrix.Others.MinFallingPathSum_931;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CorrectSolution {
    public static void main(String[] args) {
        int[][] matrix = {
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };
        System.out.println(minPathSum(matrix));
    }

    public static int minPathSum(int[][] matrix) {
        if (matrix.length == 1) {
            return matrix[0][0];
        }

        int[][] arr = new int[matrix.length][matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++) {
            arr[0][j] = matrix[0][j];
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int min = Integer.MAX_VALUE;
                if (j > 0) {
                    min = Math.min(min, arr[i - 1][j - 1]);
                }
                min = Math.min(min, arr[i - 1][j]);
                if (j < matrix[0].length - 1) {
                    min = Math.min(min, arr[i - 1][j + 1]);
                }
                arr[i][j] = matrix[i][j] + min;
            }
        }

        List<Integer> lastRow = new ArrayList<>();
        for (int num : arr[matrix.length - 1]) {
            lastRow.add(num);
        }

        return Collections.min(lastRow);
    }
}
