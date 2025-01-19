package LC_Questions.WholePackage.SlidingWindow.Others;

public class FindThePowerOfKSizeSubarrays_3255 {
    public static void main(String[] args) {
        FindThePowerOfKSizeSubarrays_3255 f = new FindThePowerOfKSizeSubarrays_3255();
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
    public int[] resultsArray1(int[] nums, int k) {
        int [] ans = new int [nums.length-k+1];
        int maxans = 0;
        for (int i = 0; i < nums.length; i ++) {
            int [] tempAns = new int [k];
            int j = i;
            int tempMax = 0;
            int indexAns = 0;
            while (j - i < k && j < nums.length) {
                tempMax += nums[j];
                tempAns[indexAns++] = nums[j];
                j++;
            }
            if (tempMax > maxans && checkConsecutive(tempAns)) {
                maxans = tempMax;
                ans = tempAns;
            }
        }
        return ans;
    }
    public boolean checkConsecutive(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
