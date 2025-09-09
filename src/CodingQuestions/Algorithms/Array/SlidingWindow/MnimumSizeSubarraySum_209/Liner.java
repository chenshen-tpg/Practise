package CodingQuestions.Algorithms.Array.SlidingWindow.MnimumSizeSubarraySum_209;

public class Liner {
    public static void main(String[] args) {
        Liner solution = new Liner();
        int [] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(solution.minSubArrayLen(target,nums));
    }
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0,temp = 0;
        int shortest =Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            while (temp >= target) {
                shortest = Math.min(shortest, i - left + 1);
                temp -= nums[left++];
            }
        }
        return shortest == Integer.MAX_VALUE ? 0 : shortest;
    }
}
