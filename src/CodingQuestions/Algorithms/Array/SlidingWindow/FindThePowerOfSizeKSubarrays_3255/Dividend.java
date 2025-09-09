package CodingQuestions.Algorithms.Array.SlidingWindow.FindThePowerOfSizeKSubarrays_3255;

public class Dividend {
    public static void main(String[] args) {
        Dividend f = new Dividend();
        int[] nums = new int[]{1, 2, 3, 4, 3, 2, 5};
        int k = 3;
        int[] res = f.resultsArray(nums, k);
        for (int i : res) {
            System.out.println(i);
        }

    }
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] results = new int[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            if (isConsecutiveAndSorted(nums, i, k)) {
                results[i] = nums[i + k - 1];
            } else {
                results[i] = -1;
            }
        }
        return results;
    }

    private boolean isConsecutiveAndSorted(int[] nums, int start, int k) {
        for (int i = start; i < start + k - 1; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
