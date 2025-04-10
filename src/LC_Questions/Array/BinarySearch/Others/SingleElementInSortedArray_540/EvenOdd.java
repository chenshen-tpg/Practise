package LC_Questions.Array.BinarySearch.Others.SingleElementInSortedArray_540;

public class EvenOdd {
    public static void main(String[] args) {

    }

    public int singleNonDuplicate (int [] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid + 1] == nums[mid]) {
                if ((hi - mid) % 2 == 0) lo = mid + 2;
                else hi = mid - 1;
            } else if (nums[mid - 1] == nums[mid]) {
                if ((hi - mid) % 2 == 0) lo = mid - 2;
                else lo = mid + 1;
            } else return nums[mid];
        }
        return nums[lo];
    }
}
