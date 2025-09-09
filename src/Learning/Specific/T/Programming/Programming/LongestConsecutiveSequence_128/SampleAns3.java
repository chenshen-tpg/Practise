<<<<<<<< HEAD:src/CodingQuestions/Algorithms/Hash/LongestConsecutiveSequence_128/SampleAns3.java
package CodingQuestions.Algorithms.Hash.LongestConsecutiveSequence_128;
========
package Learning.Specific.T.Programming.Programming.LongestConsecutiveSequence_128;
>>>>>>>> origin/master:src/Learning/Specific/T/Programming/Programming/LongestConsecutiveSequence_128/SampleAns3.java

import java.util.Arrays;

public class SampleAns3 {
    public static void main(String[] args) {
        SampleAns3 solution = new SampleAns3();

        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(solution.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
            int n = nums.length;
            if (n == 0) return 0;
            Arrays.sort(nums);
            int lastSmaller = Integer.MIN_VALUE;
            int cnt = 0;
            int longest = 1;

            for (int i = 0; i < n; i++) {
                if (nums[i] - 1 == lastSmaller) {
                    cnt += 1;
                    lastSmaller = nums[i];
                } else if (nums[i] != lastSmaller) {
                    cnt = 1;
                    lastSmaller = nums[i];
                }
                longest = Math.max(longest, cnt);
            }
            return longest;
    }

}
