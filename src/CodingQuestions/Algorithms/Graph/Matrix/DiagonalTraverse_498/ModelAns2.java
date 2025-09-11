package CodingQuestions.Algorithms.Graph.Matrix.DiagonalTraverse_498;

public class ModelAns2 {
    public static void main(String[] args) {

    }
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat.length == 0)
            return new int[0];

        int x = 0, y = 0, column = mat[0].length, row = mat.length;
        int result[] = new int[column * row];
        for (int i = 0; i < result.length; i++) {
            result[i] = mat[x][y];
            if ((x + y) % 2 == 0) {
                if (y == column - 1) {
                    x++;
                } else if (x == 0) {
                    y++;
                } else {
                    x--;
                    y++;
                }
            } else {
                if (x == row - 1) {
                    y++;
                } else if (y == 0) {
                    x++;
                } else {
                    x++;
                    y--;
                }
            }
        }
        return result;
    }
}
