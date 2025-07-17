package CodingQuestions.Graph.Matrix.Others.AvailableCaptureForRook_999;

public class TEST {
    public static void main(String[] args) {

    }
    public int numRookCaptures(char[][] board) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') {
                    return find(board,i,j,0,1) + find(board,i,j,1,0) + find(board,i,j,0,-1) + find(board,i,j,-1,0);
                }
            }
        }
        return 0;
    }

    public int find(char[][] b, int x, int y, int dx, int dy) {
        while (x >= 0 && x < 8 && y >= 0 && y <8 && b[x][y] != 'B') {
            if (b[x][y] == 'p') return 1;
            x += dx; y += dy;
        }
        return 0;
    }
}
