package CodingQuestions.Algorithms.Array.Intervals.MeetingRooms253;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SortPQ {
    public static void main(String[] args) {
        int [][] interval = {{0 , 30}, {5, 10}, {15, 20}};
        SortPQ m = new SortPQ();
        System.out.println(m.ModelAnswer(interval));

    }

    public static int ModelAnswer (int [][] intervals) {
//        Arrays.sort(intervals, (a, b)->Integer.compare(a[0], b[0]));
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->Integer.compare(a[1],b[1]));
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int[] arr : intervals){
            //add the earliest start meeting
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
}
