package LC_Questions.CollectionAll.Intervals.Others.MeetingRooms252;

import java.util.Arrays;

public class SortIteration {

    public static void main(String[] args) {
        SortIteration s = new SortIteration();
        int[][] intervals = {{0, 5}, {6, 10}, {12, 15}};
        boolean result = s.canAttendMeetings(intervals);
        System.out.println(result);
    }
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 0) return true;
        Arrays.sort(intervals, ((int [] a, int [] b) -> Integer.compare(a[0], b[0])));
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) return false;
            end = intervals[i][1];
        }
        return true;
    }
}
