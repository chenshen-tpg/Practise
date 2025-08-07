package CodingQuestions.Array.ArrayGeneral.MaxDiff_2016;

public class ModelAns {
    public static void main(String[] args) {

    }

    public int maximumDifference(int[] nums) {
        int i = 0, res = 0;
        for (int j = 1; j < nums.length; j++) {
            if (j > i && nums[j] > nums[i]) {
                if (nums[j] - nums[i] > res) {
                    res = nums[j] - nums[i];
                }
            } else {
                i = j;
            }
        }
        return res == 0 ? -1 : res;
    }
}
