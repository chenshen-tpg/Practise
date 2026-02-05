package CodingQuestions.Algorithms.DP.MaximalSquare_221;

public class BruteForce {
    public static void main(String[] args) {
        BruteForce m = new BruteForce();
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

}
