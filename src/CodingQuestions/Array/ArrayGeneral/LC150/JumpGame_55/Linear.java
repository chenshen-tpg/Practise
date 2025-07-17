package CodingQuestions.Array.ArrayGeneral.LC150.JumpGame_55;

public class Linear {
    public static void main(String[] args) {
        int [] nums = {2,3,1,3,4};
        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
