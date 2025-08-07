package CodingQuestions.Array.Intervals.MeetingRooms252;

import java.util.Arrays;

public class Review {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1) return true;
        Arrays.sort(intervals, (int [] a, int [] b) -> a[0] - b[0]);
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) return false;
            end = intervals[i][1];
        }
        return true;
    }
}
