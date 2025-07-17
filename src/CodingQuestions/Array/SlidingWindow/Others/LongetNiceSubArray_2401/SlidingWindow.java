package CodingQuestions.Array.SlidingWindow.Others.LongetNiceSubArray_2401;

public class SlidingWindow {
    public static void main(String[] args) {

    }
    public int longestNiceSubarray(int[] nums) {
        int maxLength = 1;
        int j = 0;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            while ((temp & nums[i]) != 0) {
                temp ^= nums[j];
                j++;
            }
            temp |= nums[j];
            maxLength = Math.max(maxLength, i - j + 1);
        }
        return maxLength;
    }
}
