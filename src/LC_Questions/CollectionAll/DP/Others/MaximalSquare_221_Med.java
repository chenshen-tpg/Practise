package LC_Questions.CollectionAll.DP.Others;

public class MaximalSquare_221_Med {
    public static void main(String[] args) {
        MaximalSquare_221_Med m = new MaximalSquare_221_Med();
        System.out.println(m.maximalSquare(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},
                {'1','1','1','1','1'},{'1','0','0','1','0'}}));
    }

    private int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    int len = 1;
                    boolean flag = true;
                    while (len + i < row && len + j < col && flag) {
                        for (int k = j; k <= len + j; k++) {
                            if (matrix[i + len][k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        for (int k = i; k <= len + i; k++) {
                            if (matrix[k][j + len] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag) len++;
                    }
                    if (max < len) max = len;
                }
            }
        }
        return max * max;
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
