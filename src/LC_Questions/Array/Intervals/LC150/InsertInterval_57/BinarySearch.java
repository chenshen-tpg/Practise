package LC_Questions.Array.Intervals.LC150.InsertInterval_57;
import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch b = new BinarySearch();
        int[][] intervals2 = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = new int[]{4, 8};
        int[][] res2 = b.insert(intervals2, newInterval2);
        for (int[] r : res2) {
            System.out.println(r[0] + " " + r[1]);
        }
    }

    private int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][] { newInterval };
        int n = intervals.length;
        int target = newInterval[0];
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (intervals[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < left; i++) {
            result.add(intervals[i]);
        }
        result.add(newInterval);
        for (int i = left; i < n; i++) {
            result.add(intervals[i]);
        }
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : result) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }
        return merged.toArray(new int[0][]);
    }
}
