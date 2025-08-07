package CodingQuestions.Array.BinarySearch.SingleElementInSortedArray_540;

public class EvenOnly {
    public static void main(String[] args) {

    }

    public int helper (int [] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid % 2 == 1) mid--;
            if (nums[mid] == nums[mid = 1]) lo = mid + 2;
            else hi = mid;
        }
        return nums[lo];
    }
}
