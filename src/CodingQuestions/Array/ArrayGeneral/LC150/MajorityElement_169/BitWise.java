package CodingQuestions.Array.ArrayGeneral.LC150.MajorityElement_169;

public class BitWise {
    public static void main(String[] args) {
        int [] nums = {3, 2, 3};
        BitWise solution = new BitWise();
        solution.majorityElementBitVersion(nums);
    }
    public int majorityElementBitVersion(int[] nums) {
        int n = nums.length;
        int majority_element = 0;
        for (int i = 0; i < 32; i++) {
            int bit = 1 << i;
            int bit_count = 0;
            for (int num : nums) {
                if ((num & bit) != 0) {
                    bit_count++;
                }
            }
            if (bit_count > n / 2) {
                majority_element |= bit;
            }
        }
        return majority_element;
    }
}
