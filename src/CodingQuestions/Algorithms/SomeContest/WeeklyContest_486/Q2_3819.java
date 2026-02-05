package CodingQuestions.Algorithms.SomeContest.WeeklyContest_486;

public class Q2_3819 {

    public int[] rotateElements(int[] nums, int k) {
        if (k == 0) return nums;
        if (nums.length == 1) return nums;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                count++;
            }
        }
        int[] memo = new int[count];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                memo[index++] = nums[i];
            }
        }
        if (count == 0) return nums;
        int rotate = k % count;
        int newIndex = 0;
        int[] newm = new int[count];
        for (int i = rotate; i < index; i++) {
            newm[newIndex++] = memo[i];
        }
        for (int i = 0; i<rotate; i++) {
            newm[newIndex++] = memo[i];
        }
        int newStart = 0;
        for (int i = 0; i < nums.length;i++) {
            if(nums[i] >= 0) {
                nums[i] = newm[newStart++];
            }
        }
        return nums;
    }

}
