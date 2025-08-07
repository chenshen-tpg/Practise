package CodingQuestions.Graph.Matrix.LonelyPixelI_531;

public class TEST {
    public static void main(String[] args) {

    }
    public int findLonelyPixel(char[][] picture) {
        int count = 0;
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[i].length; j++) {
                if (picture[i][j] == 'B') {
                    if (helper(i,j,picture)) count++;
                }
            }
        }
        return count;
    }
    public boolean helper (int row, int col, char[][] matrix) {
        int countRow = 0, countCol = 0;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[row][i] == 'B') countCol++;
            if (countCol > 1) return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][col] == 'B') countRow++;
            if (countRow > 1) return false;
        }
        return true;
    }
}
