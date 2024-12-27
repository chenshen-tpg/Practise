package LC_Questions.LC_General.Interval;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoomsii_253_med {
    public static void main(String[] args) {
        int [][] interval = {{0 , 30}, {5, 10}, {15, 20}};
        MeetingRoomsii_253_med m = new MeetingRoomsii_253_med();
        System.out.println(m.ModelAnswer(interval));

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
            if (starts[i] < ends[endsItr]) {
                rooms++;
            } else {
                endsItr++;
            }
        }
        return rooms;
    }
    public static int ModelAnswer (int [][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[1]-b[1]);
        for (int[] arr : intervals){
            if (pq.isEmpty()) pq.add(arr);
            else {
                if (pq.peek()[1] <= arr[0]){
                    pq.poll();
                }
                pq.offer(arr);
            }
        }
        return pq.size();
    }
    public static int myUnderstanding_Wrong (int [][] interval) {
        Arrays.sort(interval, (a,b)-> a[0] - b[0]);
        Arrays.sort(interval, (a,b)-> a[1] - b[1]);
        int count = 1;
        for (int i = 0; i < interval.length; i++) {
            int start = interval[0][1];
            int curStart = interval[i][0];
            int curEnd = interval[i][1];
            if (curStart > start) {
                count++;
                start = curEnd;
            }
        }
        return count;
    }
}
