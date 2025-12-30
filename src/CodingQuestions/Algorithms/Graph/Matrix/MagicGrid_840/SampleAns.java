package CodingQuestions.Algorithms.Graph.Matrix.MagicGrid_840;

public class SampleAns {
    public static void main(String[] args) {

    }
    public int numMagicSquaresInside(int[][] grid) {
        int res = 0;
        for (int i = 0; i <= grid.length - 3; i++) {
            for (int j = 0; j <= grid[0].length - 3; j++) {
                int[][] temp = new int[3][3];
                int[] validate = new int[16];
                boolean flag = true;
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        int cur = grid[i + k][j + l];
                        if (cur >= 1 && cur <= 9) {
                            validate[cur]++;
                            temp[k][l] = cur;
                        } else {
                            flag = false;
                        }
                    }
                }
                for (int k = 1; k <= 9; k++) {
                    if (validate[k] != 1) {
                        flag = false;
                    }
                }
                if (flag) {
                    boolean sumsMatch = (temp[0][0] + temp[0][1] + temp[0][2] == 15) &&
                            (temp[1][0] + temp[1][1] + temp[1][2] == 15) &&
                            (temp[2][0] + temp[2][1] + temp[2][2] == 15) &&
                            (temp[0][0] + temp[1][0] + temp[2][0] == 15) &&
                            (temp[0][1] + temp[1][1] + temp[2][1] == 15) &&
                            (temp[0][2] + temp[1][2] + temp[2][2] == 15) &&
                            (temp[0][0] + temp[1][1] + temp[2][2] == 15) &&
                            (temp[2][0] + temp[1][1] + temp[0][2] == 15);
                    if (!sumsMatch)
                        flag = false;
                }

                if (flag)
                    res++;
            }
        }
        return res;
    }
}
