package CodingQuestions.Array.BackTracking.WordSearch_79;

public class BackTracking {
    public static void main(String[] args) {

    }
    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; ++row) {
            for (int col = 0; col < board[0].length; ++col) {
                if (this.backtrack(row, col, word, 0, board)) {
                    return true;
                }
            }
        }
        return false;
    }
    boolean backtrack(int row, int col, String word, int index, char[][] board) {
        if (index >= word.length()) {
            return true;
        }
        if (row < 0 || row == board.length || col < 0 || col == board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }
        boolean res = false;
        board[row][col] = '#';
        int[] rowOffsets = { 0, 1, 0, -1 };
        int[] colOffsets = { 1, 0, -1, 0 };
        for (int d = 0; d < 4; ++d) {
            res = backtrack(row + rowOffsets[d], col + colOffsets[d], word, index + 1, board);
            if (res) {
                break;
            }
        }
        board[row][col] = word.charAt(index);
        return res;
    }
}
