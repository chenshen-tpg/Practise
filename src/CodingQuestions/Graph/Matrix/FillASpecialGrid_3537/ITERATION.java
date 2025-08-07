package CodingQuestions.Graph.Matrix.FillASpecialGrid_3537;

public class ITERATION {
    public int[][] specialGrid(int N) {
        int[][] curr = new int[1][1];
        curr[0][0] = 0;
        if (N == 0) return curr;
        for (int i = 0; i < N; i++) {
            curr = getNext(curr);
            if (curr.length == Math.pow(2, N)) return curr;
        }
        return curr;
    }

    public int[][] getNext(int[][] curr) {
        int n = curr.length;
        int extra = n * n;
        int[][] down = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                down[i][j] = curr[i][j] + extra;
            }
        }
        int[][] bottomr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bottomr[i][j] = down[i][j] + extra;
            }
        }
        int[][] left = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                left[i][j] = bottomr[i][j] + extra;
            }
        }
        int[][] ans = new int[n + n][n + n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = left[i][j];
                ans[i][j + n] = curr[i][j];
                ans[i + n][j] = bottomr[i][j];
                ans[i + n][j + n] = down[i][j];
            }
        }

        return ans;
    }
}
