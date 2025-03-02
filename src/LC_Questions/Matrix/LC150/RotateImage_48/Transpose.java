package LC_Questions.Matrix.LC150.RotateImage_48;

public class Transpose {
    public static void main(String[] args) {
        Transpose solution = new Transpose();
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        solution.transpose(matrix);
        for (int[] row : matrix) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public void transpose(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            // avoid the first line as it's
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }
}
