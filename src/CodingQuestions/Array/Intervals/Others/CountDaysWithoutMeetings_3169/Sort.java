package CodingQuestions.Array.Intervals.Others.CountDaysWithoutMeetings_3169;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int [][] arr = {{5, 7}, {1, 3}, {9, 10}};

    }
    //1->3 5->7 -> 9 -> 10
    public int countDays(int days, int[][] meetings) {
        int freeDays = 0, latestEnd = 0;
//        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(meetings,(a, b) -> a[0] - b[0]);
        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            if (start > latestEnd + 1) freeDays += start - latestEnd - 1;
            latestEnd = Math.max(latestEnd, end);
        }
        freeDays += days - latestEnd;

        return freeDays;
    }
}
