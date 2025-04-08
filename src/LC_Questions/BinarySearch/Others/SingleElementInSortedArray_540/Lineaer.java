package LC_Questions.BinarySearch.Others.SingleElementInSortedArray_540;

public class Lineaer {
    public static void main(String[] args) {

    }

    public int singleNonDuplicate(int[] nums) {
        for (int i = 0; i < nums.length - 1; i+=2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

}
