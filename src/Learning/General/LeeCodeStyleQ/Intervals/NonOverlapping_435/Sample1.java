package Learning.General.LeeCodeStyleQ.Intervals.NonOverlapping_435;

import java.util.Arrays;

public class Sample1 {
    public static void main(String[] args) {

    }
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 1;
        Arrays.sort(intervals, (a, b)-> a[1] - b[1]);
        int curEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= curEnd) {
                count++;
                curEnd = intervals[i][1];
            }
        }
        return intervals.length - count;
    }
}
