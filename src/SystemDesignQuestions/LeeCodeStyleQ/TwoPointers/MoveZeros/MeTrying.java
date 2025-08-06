package SystemDesignQuestions.LeeCodeStyleQ.TwoPointers.MoveZeros;

public class MeTrying {
    public static void main(String[] args) {

    }
    public void moveZeroes(int[] nums) {
        int index = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            } else if (nums[i] == 0) {
                count++;
            }
        }
        for (int i = nums.length - 1; i >= nums.length - count; i--) {
            nums[i] = 0;
        }
    }
}
