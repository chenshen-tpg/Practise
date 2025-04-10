package LC_Questions.Array.Intervals.LC150.MergeIntervals_56;

import java.util.Arrays;
import java.util.LinkedList;

public class Merge {
    public static void main(String[] args) {
        Merge mi = new Merge();
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        mi.merge(intervals);
        Arrays.asList(1,2);
    }

    public int[][] merge(int[][] intervals) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < intervals.length; i++) {
            min = Math.min(min, intervals[i][0]);
            max = Math.max(max, intervals[i][0]);
        }

        int[] range = new int[max - min + 1];
        for (int i = 0; i < intervals.length; i++) {
            range[intervals[i][0] - min] = Math.max(intervals[i][1] - min, range[intervals[i][0] - min]);
        }

        int start = 0, end = 0;
        LinkedList<int[]> result = new LinkedList<>();
        for (int i = 0; i < range.length; i++) {
            if (range[i] == 0) {
                continue;
            }
            if (i <= end) {
                end = Math.max(range[i], end);
            } else {
                result.add(new int[] {start + min, end + min});
                start = i;
                end = range[i];
            }
        }
        result.add(new int[] {start + min, end + min});
        return result.toArray(new int[result.size()][]);
    }
}
