package LC_Questions.WholePackage.DP.LC150.LongestCommonSubsequence_1143;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreaseSequence_300_med {

    public static void main(String[] args) {
        LongestIncreaseSequence_300_med lis = new LongestIncreaseSequence_300_med();
        System.out.println(lis.lengthOfLIS1(new int[]{0,1,0,3,2,3}));
    }
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) dp[i] =  Math.max(dp[i], dp[j] + 1);
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
    public int lengthOfLIS1(int[] nums) {
        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > sub.get(sub.size() - 1)) {
                sub.add(num);
            } else {
                int j = binarySearch(sub, num);
                sub.set(j, num);
            }
        }

        return sub.size();
    }
    private int binarySearch(ArrayList<Integer> sub, int num) {
        int left = 0;
        int right = sub.size() - 1;
        int mid = (left + right) / 2;
        while (left < right) {
            mid = (left + right) / 2;
            if (sub.get(mid) == num) {
                return mid;
            }

            if (sub.get(mid) < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
