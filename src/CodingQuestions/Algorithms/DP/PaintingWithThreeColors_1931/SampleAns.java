package CodingQuestions.Algorithms.DP.PaintingWithThreeColors_1931;

public class SampleAns {
    public static void main(String[] args) {

    }
    public int colorTheGrid(int m, int n) {
        long mod = 1_000_000_007;
        long[][][] matrixs = {
                {{2}},
                {{3}},
                {{3, 2}, {2, 2}},
                {
                        {3, 2, 1, 2},
                        {2, 2, 1, 2},
                        {1, 1, 2, 1},
                        {2, 2, 1, 2},
                },
                {
                        {3, 2, 2, 1, 0, 1, 2, 2},
                        {2, 2, 2, 1, 1, 1, 1, 1},
                        {2, 2, 2, 1, 0, 1, 2, 2},
                        {1, 1, 1, 2, 1, 1, 1, 1},
                        {0, 1, 0, 1, 2, 1, 0, 1},
                        {1, 1, 1, 1, 1, 2, 1, 1},
                        {2, 1, 2, 1, 0, 1, 2, 1},
                        {2, 1, 2, 1, 1, 1, 1, 2},
                },
        };
        int len = m == 1 ? 1 : (int) (Math.pow(2, m - 2));
        long[][] dp = new long[len][1];
        for (long[] row : dp) {
            row[0] = m == 1 ? 3 : 6;
        }
        long[][] matrix = matrixs[m - 1];
        dp = multiply(matrixPower(matrix, n - 1, mod), dp, mod);
        Long acc = 0l;
        for (long[] row : dp) {
            acc = (acc + row[0]) % mod;
        }
        return acc.intValue();

    }

    private long[][] multiply(long[][] a, long[][] b, long mod) {
        int m = a.length, n = b[0].length, p = b.length;
        long[][] c = new long[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < p; k++) {
                    c[i][j] += a[i][k] * b[k][j] % mod;
                    c[i][j] %= mod;
                }
            }
        }
        return c;
    }
    private long[][] matrixPower(long[][] matrix, long p, long mod) {
        long[][] res = new long[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            res[i][i] = 1;
        }
        long[][] tmp = matrix;
        while (p != 0) {
            // last bit is odd, then it's odd
            if ((p & 1) != 0) {
                res = multiply(res, tmp, mod);
            }
            tmp = multiply(tmp, tmp, mod);
            //divide 2
            p >>= 1;
        }
        return res;
    }
}
