package CodingQuestions.Array.ArrayGeneral.FindDuplicate_287;

public class ReplaceFirst {
    public static void main(String[] args) {
        findDuplicate(new int []{1,3,4,2,2});
    }
    public static int findDuplicate(int[] nums) {
        while (nums[0] != nums[nums[0]]) {
            int nxt = nums[nums[0]];
            nums[nums[0]] = nums[0];
            nums[0] = nxt;
        }
        return nums[0];
    }
}
