package CodingQuestions.Algorithms.Array.BackTracking.Permutation_46;

import java.util.ArrayList;
import java.util.List;

public class SampleAnswer {
    List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        SampleAnswer p = new SampleAnswer();
        System.out.println(p.permute(new int[]{1,2,3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        helper(nums, new ArrayList<>());
        return res;
    }

    public void helper(int[] nums, List<Integer> temp) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (temp.contains(nums[i])) {
                continue;
            }
            temp.add(nums[i]);
            helper(nums, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
