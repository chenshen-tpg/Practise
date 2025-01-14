package LC_Questions.WholePackage.Intervals.LC75;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingInterval_435 {
    public static void main(String[] args) {
        NonOverlappingInterval_435 solution = new NonOverlappingInterval_435();
        int[][] intervals = {{1, 2}, {3, 4}, {5, 6}};
//        solution.eraseOverlapIntervals(intervals);



    }


    public int eraseOverlapIntervals(int [][] intervals) {
        int ans = 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        for (int i = 0; i < intervals.length; i++) {
            int min = Integer.MIN_VALUE;
                int x = intervals[i][0];
                int y = intervals[i][1];
                if (x >= min){
                    min = y;
                } else {
                    ans++;
                }
        }
        return ans;
    }

    private int dfs(int[][] intervals, int prev_end , int curr_ind){
        if(curr_ind >= intervals.length) return 0;
        int picked = Integer.MIN_VALUE;
        if(intervals[curr_ind][0] >= prev_end) picked = 1 + dfs(intervals, intervals[curr_ind][1], curr_ind + 1);
        int not_picked = dfs(intervals, prev_end, curr_ind + 1);
        return Math.max(picked, not_picked);
    }
    public int eraseOverlapIntervals_recursive(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
        int n = intervals.length;
        return n - dfs(intervals, Integer.MIN_VALUE, 0);
    }



    int[] dp;
    private int dfs1(int[][] intervals, int prev_end , int curr_ind){
        if(curr_ind >= intervals.length) return 0;
        if(dp[curr_ind] != -1) return dp[curr_ind];
        int picked = Integer.MIN_VALUE;
        if(intervals[curr_ind][0] >= prev_end)picked = 1 + dfs(intervals, intervals[curr_ind][1], curr_ind + 1);
        int not_picked = dfs(intervals, prev_end, curr_ind + 1);
        return dp[curr_ind] = Math.max(picked, not_picked);
    }
    public int eraseOverlapIntervals_DP(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
        int n = intervals.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return n - dfs1(intervals, Integer.MIN_VALUE, 0);
    }
    public int eraseOverlapIntervalsxx(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);
        int n = intervals.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int prev_end = intervals[0][1];
        for(int i=1; i<n ; i++){
            int picked = Integer.MIN_VALUE;
            if(intervals[i][0] >= prev_end){
                picked = 1 + dp[i-1];
                prev_end = intervals[i][1];
            }
            int not_picked = dp[i - 1];
            dp[i] = Math.max(picked, not_picked);
        }
        return n - dp[n-1];
    }

    public int eraseOverlapIntervals_second(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int count = 0;
        int min = Integer.MIN_VALUE;
        for(int i = 0;i < intervals.length;i++) {
            int x = intervals[i][0];
            int y = intervals[i][1];
            if(x >= min){
                min = y;
            }else{
                count++;
            }

        }
        return count;
    }
    public int eraseOverlapIntervals1(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int c = 0;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < end) {
                c++;
            } else {
                end = intervals[i][1];
            }
        }

        return c;
    }
}
