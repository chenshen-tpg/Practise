package CodingQuestions.Algorithms.Array.ArrayGeneral.MonotonicArray_896;

public class TEST {
    public static void main(String[] args) {

    }
    public boolean isMonotonic(int[] nums) {
        boolean inc = false, dec = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] > nums[i]) {
                dec = true;
            }
            if (nums[i-1] < nums[i]) {
                inc = true;
            }
        }
        if (dec && inc) return false;
        else if (dec) return true;
        else return true;
    }
}
