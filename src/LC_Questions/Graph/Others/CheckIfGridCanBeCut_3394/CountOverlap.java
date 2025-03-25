package LC_Questions.Graph.Others.CheckIfGridCanBeCut_3394;

import java.util.Arrays;

public class CountOverlap {
    public static void main(String[] args) {

    }
    public boolean checkValidCuts(int n, int[][] rectangles) {
        if (rectangles == null || rectangles.length == 0) return false;
        return checkCuts(rectangles, 0) || checkCuts(rectangles, 1);
    }
    private boolean checkCuts(int[][] rectangles, int dim) {
        Arrays.sort(rectangles, (rect1, rect2) -> rect1[dim] - rect2[dim]);
        int cutCount = 0;
        int currentMaxEnd = rectangles[0][dim + 2];
        for (int i = 1; i < rectangles.length; i++) {
            if (dim + 2 >= rectangles[i].length) return false;
            int currentStart = rectangles[i][dim];
            int currentEnd = rectangles[i][dim + 2];
            if (currentStart >= currentMaxEnd) cutCount++;
            currentMaxEnd = Math.max(currentMaxEnd, currentEnd);
        }
        return cutCount >= 2;
    }
}
