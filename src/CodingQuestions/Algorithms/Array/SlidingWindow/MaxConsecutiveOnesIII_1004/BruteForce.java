package CodingQuestions.Algorithms.Array.SlidingWindow.MaxConsecutiveOnesIII_1004;

public class BruteForce {
    public static void main(String[] args) {
        BruteForce solution = new BruteForce();
        int[] nums = {1,1,0,0,0,1,1,1,0,1};
        int k = 2;
        System.out.println(solution.bruteForce(nums, k));
    }

    private int bruteForce(int[] nums, int k) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) {
                    count++;
                }
                if (count > k) break;
                max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }
}
