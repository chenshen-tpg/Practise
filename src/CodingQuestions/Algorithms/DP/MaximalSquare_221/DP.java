package CodingQuestions.Algorithms.DP.MaximalSquare_221;

public class DP {
    public static void main(String[] args) {

    }
    public int maximalSquareDP(char[][]m) {
        int row = m.length;
        int col = m[0].length;
        int[][] dp = new int[row+1][col+1];
        int max = 0;
        for (int i = 1; i <= row ; i++) {
            for (int j = 1; j <= col; j++) {
                if (m[i-1][j-1] == '1') {
                    dp[i][j] =  Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
