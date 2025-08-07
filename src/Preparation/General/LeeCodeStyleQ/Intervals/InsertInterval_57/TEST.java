package Preparation.General.LeeCodeStyleQ.Intervals.InsertInterval_57;

import java.util.ArrayList;
import java.util.List;

public class TEST {
    public static void main(String[] args) {

    }
    public int[][] insertIntervals(int[][] intervals, int[] newInterval) {
        List<int []> li = new ArrayList();
        int left = 0, right = intervals.length;
        while (left < right) {
            if (intervals[left][1] < newInterval[0]) {
                li.add(intervals[left]);
            }
            else if (intervals[left][0] <= newInterval[1]) {
                newInterval[0] = Math.min(newInterval[0], intervals[left][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[left][1]);
            } else {
                break;
            }
            left++;
        }
//        while (left < right && intervals[left][1] < newInterval[0]) {
//            li.add(intervals[left++]);
//        }
//        while (left < right && intervals[left][0] <= newInterval[1]) {
//            newInterval[0] = Math.min(newInterval[0], intervals[left][0]);
//            newInterval[1] = Math.max(newInterval[1], intervals[left][1]);
//            left++;
//        }
        li.add(newInterval);
        while(left < right) {
            li.add(intervals[left++]);
        }
        return li.toArray(new int [li.size()][2]);
    }
}
