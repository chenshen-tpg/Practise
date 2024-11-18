package Basic;

import java.util.Arrays;
import java.util.Comparator;

public class Greedy {

        // Activity class to store start and end times
        static class Activity {
            int start, end;
            Activity(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }

        // Function to perform activity selection
        public static int maxActivities(Activity[] activities) {
            // Sort activities based on their end times
            Arrays.sort(activities, Comparator.comparingInt(a -> a.end));

            // The first activity always gets selected
            int count = 1;
            int lastEndTime = activities[0].end;

            // Iterate through the rest of the activities
            for (int i = 1; i < activities.length; i++) {
                // If the start time of the current activity is greater than or equal to the end time of the last selected activity
                if (activities[i].start >= lastEndTime) {
                    count++; // Select the activity
                    lastEndTime = activities[i].end; // Update the end time of the last selected activity
                }
            }
            return count; // Return the maximum number of activities
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
