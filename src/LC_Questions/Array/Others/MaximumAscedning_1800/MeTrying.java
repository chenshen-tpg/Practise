package LC_Questions.Array.Others.MaximumAscedning_1800;

public class MeTrying {
    public static void main(String[] args) {
        int [] nums = {10,20,30,5,10,50};
        System.out.println(helper(nums));
    }
    public static int helper (int [] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int max = 0;
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                temp += nums[i];
                max = Math.max(max, temp);
            } else {
                temp = nums[i];
            }
        }
        return Math.max(max, temp);
    }
}
