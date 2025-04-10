package LC_Questions.Array.Hash.Others.ButtonWithLongestPushTime_3386;

import java.util.HashMap;

public class HashMapSolution {

    public static void main(String[] args) {
        System.out.println(buttonWithLongestTime(new int [][] {{1, 2}, {2, 5}, {1, 9}, {3, 15}}));
    }
    public static int buttonWithLongestTime(int[][] events) {
        int res = 0;
        HashMap<Integer, Integer> hm = new HashMap();
        int cur = events[0][1];
        for (int i = 1; i < events.length; i++) {
            int curTime = 0;
            curTime += cur - events[i][1];
            hm.put(events[i][0], hm.getOrDefault(events[i], events[i][1]) + curTime);
        }
        for (Integer s:hm.keySet()) res = Math.max(res, s);
        return res;
    }
}
