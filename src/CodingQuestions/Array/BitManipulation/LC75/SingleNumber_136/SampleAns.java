package CodingQuestions.Array.BitManipulation.LC75.SingleNumber_136;

public class SampleAns {
    public static void main(String[] args) {

    }
    public static int singleNumber(int[] nums) {
        int ans = 0;
        for(int num : nums) ans ^= num;
        return ans;
    }
}
