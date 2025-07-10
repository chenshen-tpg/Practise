package LC_Questions.Array.Intervals.Others.RescheduleMeeting_3439;

public class MeTrying {
    public static void main(String[] args) {
        MeTrying solution = new MeTrying();

        int eventTime = 5;
        int k = 2;
        int[] startTime = {0, 1, 2, 3, 4};
        int[] endTime = {1, 2, 3, 4, 5};

        int result = solution.maxFreeTime(eventTime, k, startTime, endTime);
        System.out.println("Max Free Time: " + result);

    }

    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int res = 0;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + endTime[i] - startTime[i];
        }
        for (int i = k - 1; i < n; i++) {
            int right = i == n - 1 ? eventTime : startTime[i + 1];
            int left = i == k - 1 ? 0 : endTime[i - k];
            res = Math.max(res, right - left - (sum[i + 1] - sum[i - k + 1]));
        }
        return res;
    }
}
