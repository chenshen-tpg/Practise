package Preparation.General.LeeCodeStyleQ.BinarySearch.SearchInRotatedSortedArray_33;

public class SampleAns2 {
    public static void main(String[] args) {

    }
    public int search(int[] nums, int target) {
        int n = nums.length - 1;
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[n]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        int ans = binarySearch(nums, 0 , l - 1, target);
        if (ans != -1) {
            return ans;
        }
        return binarySearch(nums, l, n, target);
    }
    private int binarySearch( int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
