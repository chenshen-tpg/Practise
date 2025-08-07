package CodingQuestions.Array.Intervals.CountDaysWithoutMeetings_3169;

public class TLE {
    public static void main(String[] args) {

    }
    public int countDays(int days, int[][] meetings) {
        int count = 0;
        int [] memo = new int [days];
        for (int i = 0; i < meetings.length; i++) {
            for (int j = meetings[i][0] - 1; j < meetings[i][1]; j++) {
                memo[j]++;
            }
        }

        for (int i = 0; i < days; i++) {
            if (memo[i] == 0) count++;
        }
        return count;
    }
}
