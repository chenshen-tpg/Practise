package CodingQuestions.Algorithms.Array.BinarySearch.MissingElementInSortedArray_1060;

public class TEST {
    public static void main(String[] args) {
        TEST solution = new TEST();
        solution.missingElement(new int [] {4,7,9,10}, 1);
    }

    public int missingElement(int[] nums, int k) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            count += nums[i] - nums[i - 1] - 1;
            if (count >= k) return nums[i - 1] + k;
            k -= count;
        }
        return nums[nums.length - 1] + k;
    }
}
