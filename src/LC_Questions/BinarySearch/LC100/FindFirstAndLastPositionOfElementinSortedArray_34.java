package LC_Questions.BinarySearch.LC100;

public class FindFirstAndLastPositionOfElementinSortedArray_34 {
    public static void main(String[] args) {
        FindFirstAndLastPositionOfElementinSortedArray_34 ffl = new FindFirstAndLastPositionOfElementinSortedArray_34();
        int [] res = ffl.searchRange(new int[]{5,7,7,8,8,10}, 8);
        for (int i : res) {
            System.out.println(i);
        }
    }
    public int[] searchRange(int[] nums, int target) {
        return findLeftMostIndex(nums, target) == -1 ?  new int []{-1,-1} : new int []{findLeftMostIndex(nums, target), findRightMostIndex(nums, target)};
    }
    public int findLeftMostIndex(int [] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int leftMostIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                leftMostIndex = mid;
                right = mid - 1;
            }
        }
        return leftMostIndex;
    }

    public int findRightMostIndex(int [] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int rightMostIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                rightMostIndex = mid;
                left = mid + 1;
            }
        }
        return rightMostIndex;
    }
}
