package LC_Questions.CollectionAll.Intervals.Others.MeetingRooms253;

import java.util.Arrays;

public class MeTrying {
    public static void main(String[] args) {
        int [][] interval = {{0 , 30}, {5, 10}, {15, 20}};
        MeTrying m = new MeTrying();
        System.out.println(m.meTrying(interval));

    }


    public static int meTrying (int [][] interval) {
        Arrays.sort(interval, (a,b)-> a[0] - b[0]);
        Arrays.sort(interval, (a,b)-> a[1] - b[1]);
        int count = 1;
        for (int i = 0; i < interval.length; i++) {
            int start = interval[0][1];
            int curStart = interval[i][0];
            int curEnd = interval[i][1];
            if (curStart > start) {
                count++;
                start = curEnd;
            }
        }
        return count;
    }
}
