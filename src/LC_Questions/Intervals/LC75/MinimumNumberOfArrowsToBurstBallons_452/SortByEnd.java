package LC_Questions.Intervals.LC75.MinimumNumberOfArrowsToBurstBallons_452;

import java.util.Arrays;

public class SortByEnd {
    public static void main(String[] args) {
        SortByEnd solution = new SortByEnd();
        int[][] points = {{1, 3}, {2, 4}, {5, 6}, {7, 8}};
        System.out.println(solution.findMinArrows(points));
    }

    public int findMinArrows(int [][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, (a,b) -> a[1] - b[1]);
        int arrowPos = points[0][1];
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if (arrowPos >= points[i][0]) continue;
            count++;
            arrowPos = points[i][1];
        }
        return count;
    }
}
