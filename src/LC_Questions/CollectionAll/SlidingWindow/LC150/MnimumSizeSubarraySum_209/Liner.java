package LC_Questions.CollectionAll.SlidingWindow.LC150.MnimumSizeSubarraySum_209;

public class Liner {
    public static void main(String[] args) {
        Liner solution = new Liner();
        int [] nums = {1,2,3,4,5};
        int target = 11;
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
