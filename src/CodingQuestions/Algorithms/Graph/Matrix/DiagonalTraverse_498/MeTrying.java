package CodingQuestions.Algorithms.Graph.Matrix.DiagonalTraverse_498;

public class MeTrying {
    public static void main(String[] args) {

    }
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) return new int[0];
        int rows = mat.length;
        int cols = mat[0].length;
        int[] arr = new int[rows * cols];
        int index = 0;
        int col = 0, row = 0, dir = 1;
        while (index < rows * cols) {
            arr[index++] = mat[row][col];
            if (dir == 1) {
                if (col == cols - 1) {
                    row++;
                    dir = -1;
                } else if (row == 0) {
                    col++;
                    dir = -1;
                } else {
                    row--;
                    col++;
                }
            } else {
                if (row == rows - 1) {
                    col++;
                    dir = 1;
                } else if (col == 0) {
                    row++;
                    dir = 1;
                } else {
                    row++;
                    col--;
                }
            }
        }
        return arr;
    }
}
