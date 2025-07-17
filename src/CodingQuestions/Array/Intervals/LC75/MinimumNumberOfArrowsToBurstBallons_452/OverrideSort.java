package CodingQuestions.Array.Intervals.LC75.MinimumNumberOfArrowsToBurstBallons_452;

import java.util.Arrays;
import java.util.Comparator;

public class OverrideSort {
    public static void main(String[] args) {
        OverrideSort solution = new OverrideSort();
        int[][] points = {{1, 3}, {2, 4}, {5, 6}, {7, 8}};
        System.out.println(solution.findMinArrowShots(points));
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] <= 0 && o2[1] >= 0){
                    return -1;
                }
                if (o1[1] >= 0 && o2[1] <= 0){
                    return 1;
                }
                return o1[1] - o2[1];
            }
        });
        int arrows = 1;
        int xStart, xEnd, firstEnd = points[0][1];
        for (int[] p: points) {
            xStart = p[0];
            xEnd = p[1];
            if (firstEnd < xStart) {
                arrows++;
                firstEnd = xEnd;
            }
        }
        return arrows;
    }
}
