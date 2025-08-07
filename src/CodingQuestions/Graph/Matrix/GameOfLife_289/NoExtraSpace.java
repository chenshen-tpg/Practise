package CodingQuestions.Graph.Matrix.GameOfLife_289;

public class NoExtraSpace {
    public static void main(String[] args) {

    }

    public void gameOfLife(int[][] B) {
        int n = B.length, m = B[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int ct = 0;
                for (int nx = i - 1; nx <= i + 1; nx++)
                    for (int ny = j - 1; ny <= j + 1; ny++) {

                        if (nx == -1 || nx == n || ny == -1 || ny == m || nx == i && ny == j) continue;
                        if (B[nx][ny] == 1 || B[nx][ny] == -1) ct++;
                    }
                if (B[i][j] == 1 && (ct < 2 || ct > 3)) B[i][j] = -1;
                else if (B[i][j] == 0 && ct == 3) B[i][j] = 2;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (B[i][j] == -1) B[i][j] = 0;
                else if (B[i][j] == 2) B[i][j] = 1;
            }
        }
    }
}
