package LC_Questions.CollectionAll.DP.LC75.UniquePath_62;

import java.util.Arrays;

public class UniquePaths_62 {
    public static void main(String[] args) {
        int rows = 3, cols = 7;
        UniquePaths_62 solution = new UniquePaths_62();
        System.out.println(solution.uniquePaths(rows,cols));
    }
    public int uniquePaths(int m, int n) {
        int [][] arr = new int [m][n];
        for (int [] a : arr) Arrays.fill(a, 1);
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                arr[i][j] = arr[i-1][j] +arr[i][j-1];
            }
        }
        return arr[m-1][n-1];
    }
}
