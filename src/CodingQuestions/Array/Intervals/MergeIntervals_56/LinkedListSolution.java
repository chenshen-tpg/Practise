package CodingQuestions.Array.Intervals.MergeIntervals_56;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListSolution {
    public static void main(String[] args) {
        LinkedListSolution mi = new LinkedListSolution();
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        mi.merge_LinkedListVersion(intervals);
        Arrays.asList(1,2);
    }

    public int[][] merge_LinkedListVersion(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> m = new LinkedList<>();
        for (int[] interval : intervals) {
            if (m.isEmpty() || m.getLast()[1] < interval[0]) {
                m.add(interval);
            } else {
                m.getLast()[1] = Math.max(m.getLast()[1], interval[1]);
            }
        }
        return m.toArray(new int[m.size()][]);
    }
}
