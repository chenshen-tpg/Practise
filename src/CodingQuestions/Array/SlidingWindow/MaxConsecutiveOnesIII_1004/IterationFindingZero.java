package CodingQuestions.Array.SlidingWindow.MaxConsecutiveOnesIII_1004;

public class IterationFindingZero {
    public static void main(String[] args) {
        IterationFindingZero m = new IterationFindingZero();
        int[] nums = {1,1,0,0,0,1,1,1,0,1};
        int k = 2;
        System.out.println(m.correct(nums, k));
    }


    public int correct(int [] nums, int k) {
        int l = 0, r = 0;
        while (r < nums.length) {
            if (nums[r] == 0) {
                k--;
            }
            if (k < 0) {
                k += 1 - nums[l];
            }
            l++;
        }
        return r - l;
    }
}
