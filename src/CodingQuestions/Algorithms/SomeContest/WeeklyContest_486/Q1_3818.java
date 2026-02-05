package CodingQuestions.Algorithms.SomeContest.WeeklyContest_486;

public class Q1_3818 {
    public static void main(String[] args) {

    }
    public int minimumPrefixLength(int[] nums) {
        int r = 0;
        int i = nums.length -1;
        while (i-1 >= 0 && nums[i - 1] < nums[i]) {
            i--;
            r++;
        }
        return r;
    }

    public int myVersion(int [] nums) {
        int r = nums.length - 1;
        int count = 0;
        for (int i = r - 1; i > 0 ; i--) {
            if (nums[i - 1] < nums[i]) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}
