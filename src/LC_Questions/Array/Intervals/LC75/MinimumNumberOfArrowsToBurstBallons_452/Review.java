package LC_Questions.Array.Intervals.LC75.MinimumNumberOfArrowsToBurstBallons_452;

import java.util.Arrays;

public class Review {
    public static void main(String[] args) {
        Review solution = new Review();
        int[][] points = {{1, 3}, {2, 4}, {5, 6}, {7, 8}};
        System.out.println(solution.findMinArrows(points));
    }

    private int findMinArrows(int[][] points) {
        if (points.length == 0) return 0;
        //could be overflow if just minus
        Arrays.sort(points, (int [] a, int []b) -> Integer.compare(a[1], b[1]));
        int curPos = points[0][1];
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= curPos) continue;
            count++;
            curPos = points[i][1];
        }
        return count;
    }
}
