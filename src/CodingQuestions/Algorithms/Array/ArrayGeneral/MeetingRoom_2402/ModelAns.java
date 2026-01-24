package CodingQuestions.Algorithms.Array.ArrayGeneral.MeetingRoom_2402;

import java.util.Arrays;

public class ModelAns {
    public static void main(String[] args) {
        ModelAns solution = new ModelAns();
        int[][] meetings = new int[][]{{0, 10},{1, 5},{2, 7},{3, 4}};
        int result = solution.mostBooked(2, meetings);
        System.out.println(result);
    }
    public int mostBooked(int n, int[][] meetings) {
        long[] memo = new long[n];
        int[] meetingCount = new int[n];
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            long minRoomAvailabilityTime = Long.MAX_VALUE;
            int roomCount = 0;
            boolean foundUnusedRoom = false;

            for (int i = 0; i < n; i++) {
                if (memo[i] <= start) {
                    foundUnusedRoom = true;
                    meetingCount[i]++;
                    memo[i] = end;
                    break;
                }
                if (minRoomAvailabilityTime > memo[i]) {
                    minRoomAvailabilityTime = memo[i];
                    roomCount = i;
                }
            }
            if (!foundUnusedRoom) {
                memo[roomCount] += end - start;
                meetingCount[roomCount]++;
            }
        }
        int maxMeetingCount = 0, maxMeetingCountRoom = 0;
        for (int i = 0; i < n; i++) {
            if (meetingCount[i] > maxMeetingCount) {
                maxMeetingCount = meetingCount[i];
                maxMeetingCountRoom = i;
            }
        }

        return maxMeetingCountRoom;
    }
}
