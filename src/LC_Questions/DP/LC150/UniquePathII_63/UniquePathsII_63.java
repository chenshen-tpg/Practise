package LC_Questions.DP.LC150.UniquePathII_63;

public class UniquePathsII_63 {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        int result = method(arr);
        System.out.println("Number of unique paths: " + result);
    }


    public static int method (int[][] arr) {
        if (arr[0][0] == 1) return 0;
        arr[0][0] = 1;
        int row = arr.length;
        int col = arr[0].length;
        for (int i = 1; i < row; i++) {
            if (arr[i-1][0] == 1 && arr[i][0] == 0) arr[i][0] = 1;
            else arr[i][0] = 0;
        }
        for (int i = 1; i < col; i++) {
            if (arr[0][i-1] == 1 && arr[0][i] == 0) arr[i][0] = 1;
            else arr[0][i] = 0;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (arr[i][j] == 0) arr[i][j] = arr[i-1][j] + arr[i][j-1];
                else arr[i][j] = 0;
            }
        }
        return arr[row-1][col-1];
    }
}
