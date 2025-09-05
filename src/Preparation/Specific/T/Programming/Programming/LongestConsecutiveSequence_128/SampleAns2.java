package Preparation.Specific.T.Programming.Programming.LongestConsecutiveSequence_128;

import java.util.HashSet;
import java.util.Set;

public class SampleAns2 {
    public static void main(String[] args) {
        SampleAns2 solution = new SampleAns2();

        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(solution.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Set<Integer> s = new HashSet();
        int max = 1;
        for (int x : nums) s.add(x);
        for (int n : s) {
            if (!s.contains(n - 1)) {
                int cnt = 1;
                int temp = n;
                while (s.contains(temp + 1)) {
                    temp++;
                    cnt++;
                }
                max = Math.max(max, cnt);
            }
        }
        return max;
    }
}
