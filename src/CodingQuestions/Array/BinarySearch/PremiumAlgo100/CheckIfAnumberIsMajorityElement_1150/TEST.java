package CodingQuestions.Array.BinarySearch.PremiumAlgo100.CheckIfAnumberIsMajorityElement_1150;

public class TEST {
    public static void main(String[] args) {

    }

    public boolean isMajorityElement(int[] nums, int target) {
        int firstIndex = lower_bound(nums, target);
        int nextToLastIndex = upper_bound(nums, target);
        return nextToLastIndex - firstIndex > nums.length / 2;
    }

    int lower_bound(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int index = nums.length;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] >= target) {
                end = mid - 1;
                index = mid;
            } else {
                start = mid + 1;
            }
        }
        return index;
    }

    int upper_bound(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int index = nums.length;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] > target) {
                end = mid - 1;
                index = mid;
            } else {
                start = mid + 1;
            }
        }

        return index;
    }

}
