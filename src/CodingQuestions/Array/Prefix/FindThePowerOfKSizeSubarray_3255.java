package CodingQuestions.Array.Prefix;

public class FindThePowerOfKSizeSubarray_3255 {
    public static void main(String[] args) {
        FindThePowerOfKSizeSubarray_3255 f = new FindThePowerOfKSizeSubarray_3255();
        int [] nums = {1,2,3,4,3,2,5};
        int k = 3;
        f.upvoteAnswer2(nums, k);
    }
    public int[] upvoteAnswer2(int[] nums, int k) {
        int n = nums.length;
        int[] results = new int[n - k + 1];
        int[] maxInWindow = new int[n - k + 1];
        for (int i = 0; i < k; i++) {
            maxInWindow[0] = Math.max(maxInWindow[0], nums[i]);
        }
        for (int i = 1; i <= n - k; i++) {
            maxInWindow[i] = Math.max(maxInWindow[i - 1], nums[i + k - 1]);
        }
        for (int i = 0; i <= n - k; i++) {
            if (isConsecutiveAndSorted(nums, i, k)) {
                results[i] = maxInWindow[i];
            } else {
                results[i] = -1;
            }
        }
        return results;
    }

    private boolean isConsecutiveAndSorted(int[] nums, int j, int k) {
        for (int i = j; i < j + k - 1; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
    public int[] upvoteAnswer(int[] nums, int k) {
        int[] num = new int[nums.length];
        int[] vec = new int[nums.length - k + 1];
        num[0] = 1;
        int a = 1;
        // Create the prefix array num for all consecutive numbers
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                a++;
                num[i] = a;
            } else {
                a = 1;
                num[i] = a;
            }
        }
        for (int i = 0; i <= nums.length - k; i++) {
            if ((num[i + k - 1] - num[i] + 1) == k) {
                vec[i] = nums[i + k - 1];
            } else {
                vec[i] = -1;
            }
        }
        return vec;
    }
}
