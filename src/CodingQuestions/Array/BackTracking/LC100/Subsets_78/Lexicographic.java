package CodingQuestions.Array.BackTracking.LC100.Subsets_78;

import java.util.ArrayList;
import java.util.List;

public class Lexicographic {

    public static void main(String[] args) {
        System.out.println(subsets_Lexicographic(new int[]{1,2,3}));
    }


    public static List<List<Integer>> subsets_Lexicographic (int[] nums) {
        List<List<Integer>> output = new ArrayList();
        int n = nums.length;
        for (int i = (int) Math.pow(2, n); i < (int) Math.pow(2, n + 1); ++i) {
            String bitmask = Integer.toBinaryString(i).substring(1);
            List<Integer> curr = new ArrayList();
            for (int j = 0; j < n; ++j) if (bitmask.charAt(j) == '1') curr.add(nums[j]);
            output.add(curr);
        }
        return output;
    }


}
