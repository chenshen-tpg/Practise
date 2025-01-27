package LC_Questions.CollectionAll.Intervals.LC150.MergeIntervals_56;

import java.util.Arrays;
import java.util.LinkedList;

public class Review {
    public static void main(String[] args) {
        Review mi = new Review();
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        mi.merge_LinkedListVersion(intervals);
        Arrays.asList(1,2);
    }

    private int[][] merge_LinkedListVersion(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int []> list = new LinkedList<>();
        // we could always add a list.isEmpty() to start the loop from the beginning
//        list.add(intervals[0]);
//        for (int i = 0; i < intervals.length; i++) {
//            if (intervals[i][0] > list.getLast()[1]) list.add(intervals[i]);
        for (int i = 0; i < intervals.length; i++) {
            if (list.isEmpty() || intervals[i][0] > list.getLast()[1]) list.add(intervals[i]);
            else {
                list.getLast()[1] = Math.max(list.getLast()[1], intervals[i][1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
