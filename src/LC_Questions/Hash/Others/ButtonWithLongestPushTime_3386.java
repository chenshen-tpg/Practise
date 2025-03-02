package LC_Questions.Hash.Others;

import java.util.HashMap;

public class ButtonWithLongestPushTime_3386 {
    public static void main(String[] args) {
        int[][] events = {
                {1, 2},
                {2, 5},
                {1, 9},
                {3, 15}
        };
        System.out.println(buttonWithLongestTime(events));
    }
    public static int buttonWithLongestTime(int[][] events) {
        HashMap<Integer, Integer> hm = new HashMap();
        int cur = events[0][1];
        for (int i = 1; i < events.length; i++) {
            int curTime = 0;
            curTime += cur - events[i][1];
            hm.put(events[i][0], hm.getOrDefault(events[i], events[i][1]) + curTime);
        }
        int res = 0;
        for (Integer s:hm.keySet()) {
            Math.max(res, s);
        }
        return res;
    }
}
