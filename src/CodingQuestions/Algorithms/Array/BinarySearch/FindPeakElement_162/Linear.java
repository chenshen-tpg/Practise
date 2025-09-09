package CodingQuestions.Algorithms.Array.BinarySearch.FindPeakElement_162;

public class Linear {
    public static void main(String[] args) {

    }
    public int findPeakElementLiner(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) return i;
        }
        return nums.length - 1;
    }
}
