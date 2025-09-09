package CodingQuestions.Algorithms.Array.ArrayGeneral;

public class JumpGameII_55 {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4 , 1, 1 ,2, 1, 2};
        System.out.println(jump(nums1)); // Output: 2

    }
    public static int jump(int[] nums) {
        if (nums.length < 2) return 0;
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }
        return jumps;
    }
}
