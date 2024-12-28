package LC_Questions.ClassicQ;

public class JumpGameII_55 {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 1, 4 , 1, 1 ,2, 1, 2};
        System.out.println(jump(nums1)); // Output: 2

    }
    public static int jump(int[] nums) {
        int count = 0, cur = 0, max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, nums[i] + i);
            if (i == cur) {
                count++;
                cur = max;
            }
        }
        return count;
    }
}
