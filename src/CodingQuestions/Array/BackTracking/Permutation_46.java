package CodingQuestions.Array.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation_46 {
    public static void main(String[] args) {
        Permutation_46 p = new Permutation_46();
        System.out.println(p.permute(new int[]{1,2,3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, new ArrayList<>(), res);
        return res;
    }

    public void helper(int[] nums, List<Integer> temp, List<List<Integer>> res) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            helper(nums, temp, res);
            temp.remove(temp.size() - 1);
        }
    }

}
