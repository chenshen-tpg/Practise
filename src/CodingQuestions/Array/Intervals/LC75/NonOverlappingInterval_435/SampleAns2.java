package CodingQuestions.Array.Intervals.LC75.NonOverlappingInterval_435;

import java.util.Arrays;

public class SampleAns2 {
    public static void main(String[] args) {

    }
    public int eraseOverlapIntervals1(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int c = 0;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                c++;
            } else {
                end = intervals[i][1];
            }
        }

        return c;
    }
}
