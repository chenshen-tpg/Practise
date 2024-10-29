package LC_Questions.LC_75.Intervals;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingInterval_435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int count = 0;
        int min = Integer.MIN_VALUE;
        for(int i = 0;i < intervals.length;i++) {
            int x = intervals[i][0];
            int y = intervals[i][1];
            if(x >= min){
                min = y;
            }else{
                count++;
            }

        }
        return count;
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
