package CodingQuestions.Graph.Matrix.MinFallingPathSum_931;

public class BUDPWithoutExtraSpace {
    public static void main(String[] args) {
        int[][] matrix = {
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };
        System.out.println(minFallingPathSum(matrix));
    }

    private static int minFallingPathSum(int[][] matrix) {
        if (matrix.length == 1) return matrix[0][0];
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int min = Integer.MAX_VALUE;
                if (j > 0) min = Math.min(min, matrix[i - 1][j - 1]);
                min = Math.min(min,  matrix[i - 1][j]);
                if (j < matrix[0].length - 1) min = Math.min(min, matrix[i - 1][j + 1]);
                matrix[i][j] = matrix[i][j] + min;
            }
        }
        // Solution
//        List<Integer> lastRow = new ArrayList<>();
//        for (int num : matrix[matrix.length - 1]) lastRow.add(num);
//        return Collections.min(lastRow);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            min = Math.min(matrix[matrix.length - 1][i], min);
        }
        return min;
    }
}
