package LC_Questions.CollectionAll.BinarySearch;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestSquareStreakInAnArray_2501 {
    public static void main(String[] args) {
        LongestSquareStreakInAnArray_2501 ls = new LongestSquareStreakInAnArray_2501();
        System.out.println(ls.longestSquareStreak(new int[]{4,3,6,16,8,2}));
    }
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        Set<Integer> processedNumbers = new HashSet<>();
        int longestStreak = 0;
        for (int current : nums) {
            if (processedNumbers.contains(current)) continue;

            int streak = current;
            int streakLength = 1;
            while (true) {
                if ((long) streak * (long) streak > 1e5) break;
                if (binarySearch(nums, streak * streak)) {
                    streak *= streak;
                    processedNumbers.add(streak);
                    streakLength++;
                } else {
                    break;
                }
            }
            longestStreak = Math.max(longestStreak, streakLength);
        }
        return longestStreak < 2 ? -1 : longestStreak;
    }
    private boolean binarySearch(int[] nums, int target) {
        if (target < 0) return false;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;
            if (nums[mid] > target) right = mid - 1;
            else left = mid + 1;
        }
        return false;
    }
}
