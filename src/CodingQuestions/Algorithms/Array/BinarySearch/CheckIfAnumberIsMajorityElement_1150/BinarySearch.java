package CodingQuestions.Algorithms.Array.BinarySearch.CheckIfAnumberIsMajorityElement_1150;

public class BinarySearch {
    public static void main(String[] args) {

    }
    public boolean isMajorityElement(int[] nums, int target) {
        int firstIndex = helper(nums, target, true);
        if (firstIndex == -1) {
            return false;
        }
        int lastIndex = helper(nums, target, false);
        return lastIndex - firstIndex + 1 > nums.length / 2;
    }

    public int helper(int[] nums, int target, boolean findFirst) {
        int start = 0, end = nums.length - 1, index = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                index = mid;
                //continue searching until we find the first
                if (findFirst) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return index;
    }

}
