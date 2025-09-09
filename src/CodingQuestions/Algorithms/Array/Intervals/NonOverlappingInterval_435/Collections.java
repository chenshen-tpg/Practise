package CodingQuestions.Algorithms.Array.Intervals.NonOverlappingInterval_435;

import java.util.Arrays;
import java.util.Comparator;

public class Collections {
    public static void main(String[] args) {
        Collections solution = new Collections();
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

}
