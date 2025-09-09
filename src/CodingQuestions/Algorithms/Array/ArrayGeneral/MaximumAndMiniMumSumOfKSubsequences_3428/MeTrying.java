package CodingQuestions.Algorithms.Array.ArrayGeneral.MaximumAndMiniMumSumOfKSubsequences_3428;

import java.util.List;

//MatSolution
public class MeTrying {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 2;

    }

    public int helper(int[] nums, int i, int k, List<Integer> li) {
        int ans = 0;
        for (int j = 0; j < nums.length; j++) {
            helper(nums, i + 1, k, li);
            li.add(j);
        }


        return ans;
    }
}
