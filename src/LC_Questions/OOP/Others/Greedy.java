package LC_Questions.OOP.Others;

import java.util.Arrays;
import java.util.Comparator;

public class Greedy {

    static class Activity {
        int start, end;
        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int maxActivities(Activity[] activities) {
        Arrays.sort(activities, Comparator.comparingInt(a -> a.end));
        int count = 1;
        int lastEndTime = activities[0].end;
        for (int i = 1; i < activities.length; i++) {
            if (activities[i].start >= lastEndTime) {
                count++;
                lastEndTime = activities[i].end;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Activity[] activities = {
                new Activity(1, 3),
                new Activity(2, 5),
                new Activity(4, 6),
                new Activity(6, 8),
                new Activity(5, 7),
                new Activity(8, 9)
        };
        System.out.println("Maximum number of activities: " + maxActivities(activities));

    }
}
