package Learning.Specific.T.Programming.Programming.BrightestPostionOnStreet_2021;

import java.util.Arrays;

public class SampleAns {
    public static void main(String[] args) {
//        lights = [[-3,2],[1,2],[3,3]]
        SampleAns sa = new SampleAns();
        int[][] lights = {{-3, 2}, {1, 2}, {3, 3}};
        int result = sa.brightestPosition(lights);
        System.out.println("Brightest position: " + result);
    }

    public int brightestPosition(int[][] lights) {
        int len = lights.length;
        int[] start = new int[len];
        int[] end = new int[len];
        for (int i = 0; i < len; i++) {
            start[i] = lights[i][0] - lights[i][1];
            end[i] = lights[i][0] + lights[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i = 0, j = 0;
        int max = 0, bright = 0, ans = start[0];
        while (i < len) {
            int curStart = start[i];
            int curEnd = end[j];
            if (curStart <= curEnd) {
                i++;
                bright++;
            } else {
                j++;
                bright--;
            }
            if (bright > max) {
                max = bright;
                ans = curStart;
            }
        }
        return ans;
    }
}
