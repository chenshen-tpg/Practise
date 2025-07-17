package CodingQuestions.Math.Others.Unique3DigitsEven_3483;

import java.util.ArrayList;
import java.util.List;

public class TEST {

    public static int ans = 0;
    public static void main(String[] args) {
        totalNumbers(new int [] {1,2,3});
    }
    public static int totalNumbers(int[] digits) {
        helper(digits,0, new ArrayList<Integer>());
        return ans;
    }

    private static void helper(int[] digits, int index, List<Integer> list) {
    }

}
