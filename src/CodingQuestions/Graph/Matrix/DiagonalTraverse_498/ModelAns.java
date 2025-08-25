package CodingQuestions.Graph.Matrix.DiagonalTraverse_498;

public class ModelAns {
    public static void main(String[] args) {
        ModelAns solution = new ModelAns();
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[] result = solution.findDiagonalOrder(mat);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public int[] findDiagonalOrder(int[][] mat) {
        if (mat.length == 0 || mat[0].length == 0) {
            return new int[0];
        }
        int m = mat.length, n = mat[0].length;
        int row = 0, col = 0;
        int index = 0;
        int[] arr = new int[m * n];
        boolean up = true;
        while (index < m * n) {
            arr[index++] = mat[row][col];
            if (up) {
                if (col == n - 1) {
                    row++;
                    up = false;
                } else if (row == 0) {
                    col++;
                    up = false;
                } else {
                    row--;
                    col++;
                }
            } else {
                if (row == m - 1) {
                    col++;
                    up = true;
                } else if (col == 0) {
                    row++;
                    up = true;
                } else {
                    row++;
                    col--;
                }
            }
        }
        return arr;
    }
}
