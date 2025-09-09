package CodingQuestions.Algorithms.Hash.ButtonWithLongestPushTime_3386;

public class Linear {
    public static void main(String[] args) {
        Linear linear = new Linear();
        int[][] events1 = {{8, 4}, {7, 6}, {19, 9}, {8, 14}, {13, 15}, {2, 16}, {2, 18}};
        System.out.println(linear.buttonWithLongestTime(events1));

        int[][] events2 = {{1, 2}, {2, 5}, {3, 9}, {1, 15}};
        System.out.println(linear.buttonWithLongestTime(events2));

        int[][] events3 = {{10, 5}, {1, 7}};
        System.out.println(linear.buttonWithLongestTime(events3));
    }
    public int buttonWithLongestTime(int[][] events) {
        int ans = events[0][0];
        int prev = events[0][1];
        int max = events[0][1];
        for (int i = 1; i < events.length; i++) {
            if (events[i][1] - prev > max) {
                max = events[i][1] - prev;
                ans = events[i][0];
                prev = events[i][1];
            }

        }
        return ans;
    }
}
