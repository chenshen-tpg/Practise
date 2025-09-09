package CodingQuestions.Algorithms.Array.SlidingWindow.MaxConsecutiveOnesIII_1004;

public class MeTrying {
    public static void main(String[] args) {
        int [] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;

    }
    public int iteration (int [] nums, int k) {
        int left  = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) k--;
            if (k < 0) {
                if (nums[left] == 0) {
                    k++;
                }
                left++;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
