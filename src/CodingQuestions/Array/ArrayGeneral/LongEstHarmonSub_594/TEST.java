package CodingQuestions.Array.ArrayGeneral.LongEstHarmonSub_594;

import java.util.Arrays;

public class TEST {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);  // Step 1: Sort the array
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > 1) {
                left++;
            }
            if (nums[right] - nums[left] == 1) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen;
    }
}
