package CodingQuestions.Array.ArrayGeneral.MajorityElement_169;

import java.util.Arrays;

public class Sort {
    public int majorityElement_wtf(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
