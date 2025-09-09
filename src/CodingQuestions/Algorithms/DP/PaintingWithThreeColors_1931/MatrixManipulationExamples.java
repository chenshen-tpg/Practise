package CodingQuestions.Algorithms.DP.PaintingWithThreeColors_1931;

public class MatrixManipulationExamples {
    public static void main(String[] args) {


    }
    // Normal (naive) matrix exponentiation: O(n)
    long[][] normalMatrixPower(long[][] matrix, long p, long mod) {
        int size = matrix.length;
        long[][] res = new long[size][size];
        for (int i = 0; i < size; i++) res[i][i] = 1;
        for (long i = 0; i < p; i++) {
            res = multiply(res, matrix, mod);
        }
        return res;
    }
    // Fast matrix exponentiation: O(log n)
    long[][] fastMatrixPower(long[][] matrix, long p, long mod) {
        int size = matrix.length;
        long[][] res = new long[size][size];
        for (int i = 0; i < size; i++) res[i][i] = 1;
        long[][] tmp = matrix;
        while (p > 0) {
            if ((p & 1) != 0) res = multiply(res, tmp, mod);
            tmp = multiply(tmp, tmp, mod);
            p >>= 1;
        }
        return res;
    }
    // Matrix multiplication helper
    long[][] multiply(long[][] a, long[][] b, long mod) {
        int m = a.length, n = b[0].length, p = b.length;
        long[][] c = new long[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < p; k++)
                    c[i][j] = (c[i][j] + a[i][k] * b[k][j] % mod) % mod;
        return c;
    }
}
