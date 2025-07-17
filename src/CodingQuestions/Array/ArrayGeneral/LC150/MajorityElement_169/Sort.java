package CodingQuestions.Array.ArrayGeneral.LC150.MajorityElement_169;

import java.util.Arrays;

public class Sort {
    public int majorityElement_wtf(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
