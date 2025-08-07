package CodingQuestions.Array.SlidingWindow.LongestSubarrayOf1sAfterDeletingOneElement_1493;

public class SecondReview {
    public static void main(String[] args) {

    }
    public int longestSubarray(int[] nums) {
        int ans = 0;
        int count = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            }
            while (count > 1) {
                if (nums[index++] == 0) {
                    count--;
                }
            }
            ans = Math.max(ans, i - index);
        }
        return ans;
    }
}
