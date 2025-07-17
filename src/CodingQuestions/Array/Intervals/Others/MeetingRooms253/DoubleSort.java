package CodingQuestions.Array.Intervals.Others.MeetingRooms253;

import java.util.Arrays;

public class DoubleSort {
    public static void main(String[] args) {
        int [][] interval = {{0 , 30}, {5, 10}, {15, 20}};
        DoubleSort m = new DoubleSort();
        System.out.println(m.minMeetingRoomsSolutions(interval));

    }
    public int minMeetingRoomsSolutions(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0, endsItr = 0;
        for (int i = 0; i < starts.length; i++) {
            //start[0,5,15] end[10,20,30]
            if (starts[i] < ends[endsItr]) {
                rooms++;
            } else {
                endsItr++;
            }
        }
        return rooms;
    }
}
