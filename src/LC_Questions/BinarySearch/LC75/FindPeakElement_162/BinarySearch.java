package LC_Questions.BinarySearch.LC75.FindPeakElement_162;

public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch f = new BinarySearch();
        int[] nums = {1,2,3,1};
        System.out.println(f.findPeakElement(nums));
    }


    public int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    public int search(int[] nums, int l, int r) {
        if (l == r) return l;
        int mid = (l + r) / 2;
        if (nums[mid] < nums[mid + 1]) return search(nums, mid + 1, r) ;
        return search(nums, l, mid);
    }
}
