package CodingQuestions.Array.SlidingWindow.MaximumAverageSubarrayI_643;

public class MeTrying {
    public static void main(String[] args) {
        MeTrying solution = new MeTrying();
        int [] nums = {5};
        int k = 1;
        System.out.println(solution.prefix(nums, k));
    }

    public double prefix (int [] nums, int k) {

        int add = 0;
        for (int i = 0; i < k; i++) {
            add += nums[i];
        }
        double max = add * 1.0 / k;
        int index = 0;
        for (int i = k; i < nums.length; i++) {
            add += nums[i];
            add -= nums[index++];
            max = Math.max(max, add * 1.0 / k);
        }
       return max;
    }
}
