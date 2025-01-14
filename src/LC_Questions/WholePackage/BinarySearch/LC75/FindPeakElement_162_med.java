package LC_Questions.WholePackage.BinarySearch.LC75;

public class FindPeakElement_162_med {
    public static void main(String[] args) {
        FindPeakElement_162_med f = new FindPeakElement_162_med();
        int[] nums = {1,2,3,1};
        System.out.println(f.findPeakElement(nums));
    }
    public int findPeakElementLiner(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) return i;
        }
        return nums.length - 1;
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
