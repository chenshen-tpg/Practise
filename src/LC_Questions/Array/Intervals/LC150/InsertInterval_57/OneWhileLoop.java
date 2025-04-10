package LC_Questions.Array.Intervals.LC150.InsertInterval_57;

import java.util.ArrayList;
import java.util.List;

public class OneWhileLoop {

    public static void main(String[] args) {
        OneWhileLoop ii = new OneWhileLoop();
        int[][] intervals = new int[][]{{1, 3}, {6, 9}};
        int[] newInterval = new int[]{2, 5};
        int[][] res = ii.insert(intervals, newInterval);
        for (int[] r : res) {
            System.out.println(r[0] + " " + r[1]);
        }
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int l = 0, r = intervals.length;

        while (l < r) {
            if (intervals[l][1] < newInterval[0]) {
                res.add(intervals[l]);
            } else if (intervals[l][0] <= newInterval[1]) {
                newInterval[0] = Math.min(newInterval[0], intervals[l][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[l][1]);
            } else {
                break;
            }
            l++;
        }
        res.add(newInterval);
        while (l < r) {
            res.add(intervals[l]);
            l++;
        }
        return res.toArray(new int[res.size()][]);
    }
}
