package CodingQuestions.Array.ArrayGeneral.Others.CheckIfArrayIsSortedAndRotated_1752;

public class CountingInverse {
    public static void main(String[] args) {

    }
    public boolean stcheck(int[] nums) {
        if (nums.length == 1) return true;
        int count = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] < nums[i - 1]) {
                count++;
            }
        }
        if (nums[0] < nums[ nums.length - 1]) {
            count++;
        }
        return count <= 1;
    }
}
