package LC_Questions.Array.LC150.JumpGame_55;

public class WhileLoop {
    public static void main(String[] args) {
        int [] nums = {2,3,1,3,4};
        System.out.println(canJump(nums));
    }
    public static boolean canJump(int[] nums) {
        int distance = nums[0];
        while (distance < nums.length) {
            distance += nums[distance];
            if (distance == nums.length) {
                return true;
            }
        }
        return false;
    }

}
