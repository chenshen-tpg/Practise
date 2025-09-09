package Learning.General.LeeCodeStyleQ.Intervals.MergeIntervals_56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TEST {
    public static void main(String[] args) {

    }
    public int[][] mergeIntervals(int[][] intervals) {
        List<int []> li = new ArrayList();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int[] interval : intervals) {
            if (li.isEmpty() || interval[0] > li.get(li.size() - 1)[1]) {
                li.add(interval);
            } else {
                li.get(li.size() - 1)[1] = Math.max(interval[1], li.get(li.size() - 1)[1]);
            }
        }
        return li.toArray(new int [li.size()][2]);
    }
}
