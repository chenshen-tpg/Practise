package LC_Questions.LC_150.BinarySearch;

public class FindMinimuminRotatedSortedArray_153_med {
    public static void main(String[] args) {
        FindMinimuminRotatedSortedArray_153_med f = new FindMinimuminRotatedSortedArray_153_med();
        int[] nums = {3,4,5,1,2};
        System.out.println(f.findMin(nums));

    }
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0, right = nums.length - 1;
        if (nums[right] > nums[0]) {
            return nums[0];
        }
        while (right >= left) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if (nums[mid - 1] > nums[mid])  return nums[mid];
            if (nums[mid] > nums[0]) left = mid + 1;
            else right = mid - 1;
        }
        return Integer.MAX_VALUE;
    }
    public int findMinSimple(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] < nums[r]) r = m;
            else l = m + 1;
        }
        return nums[l];
    }
}
