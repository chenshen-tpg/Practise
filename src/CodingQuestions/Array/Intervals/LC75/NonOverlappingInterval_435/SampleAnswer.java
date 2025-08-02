package CodingQuestions.Array.Intervals.LC75.NonOverlappingInterval_435;

import java.util.Arrays;

public class SampleAnswer {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        int res = 1;
        Arrays.sort(intervals, (a, b) -> (a[1] - b[1]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int i = 1; i < n; i++) {
            int[] num = intervals[i];
            if (num[0] >= end) {
                res++;
                start = num[0];
                end = num[1];
            }
        }
        return n - res;
    }
}
