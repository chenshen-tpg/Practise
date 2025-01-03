package LC_Questions.WholePackage.Intervals;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval_57 {
    public static void main(String[] args) {
        InsertInterval_57 ii = new InsertInterval_57();
        int[][] intervals = new int[][]{{1, 3}, {6, 9}};
        int[] newInterval = new int[]{2, 5};
        int[][] res = ii.insert(intervals, newInterval);
        for (int[] r : res) {
            System.out.println(r[0] + " " + r[1]);
        }
    }
    public int[][] insert(int[][] intv, int[] newint) {
        List<int[]> res = new ArrayList<>();
        int l = 0, r = intv.length;

        while (l < r && intv[l][1] < newint[0]){
            res.add(intv[l]);
            l++;
        }

        while (l < r && intv[l][0] <= newint[1]) {
            newint[0] = Math.min(intv[l][0], newint[0]);
            newint[1] = Math.max(intv[l][1], newint[1]);
            l++;
        }
        res.add(newint);

        while (l < r) {
            res.add(intv[l]);
            l++;
        }
        return res.toArray(new int[res.size()][]);
    }
}
