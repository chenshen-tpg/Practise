package LC_Questions.Graph.Graph.Others.CheckIfGridCanBeCut_3394;

import java.util.Arrays;

public class CountOverlap {
    public static void main(String[] args) {

    }
    public boolean checkValidCuts(int n, int[][] rectangles) {
        if (rectangles == null || rectangles.length == 0) return false;
        return checkCuts(rectangles, 0) || checkCuts(rectangles, 1);
    }

    public boolean checkCuts (int [][] arr, int dim) {
        Arrays.sort(arr, (r1, r2) -> r1[dim] - r2[dim]);
        int count = 0, temp = arr[0][dim + 2];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][dim] >= temp) count++;
            temp = Math.max(temp, arr[i][dim + 2]);
        }
        return count >= 2;
    }
}
