package LC_Questions.Graph.Matrix.LC150.RotateImage_48;

public class Review {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }




//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length / 2; j++) {
//                int tmp = matrix[i][j];
//                matrix[i][j] = matrix[i][matrix[i].length - j - 1];
//                matrix[i][matrix[i].length - j - 1] = tmp;
//            }
//        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
