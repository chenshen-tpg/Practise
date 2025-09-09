package CodingQuestions.Algorithms.Array.Intervals.NonOverlappingInterval_435;

import java.util.Arrays;

public class DP {
    public static void main(String[] args) {

    }
    public int eraseOverlapIntervalsxx(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
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

}
