package CodingQuestions.Algorithms.BackTracking.CombinationSumI_39;

import java.util.ArrayList;
import java.util.List;

public class RecursiveArr {
    public static void main(String[] args) {

    }
    ArrayList<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates, target, 0, new ArrayList<>());
        return res;
    }

    public void helper(int[] candidates, int target, int start, List<Integer> al) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            res.add(new ArrayList<>(al));
        }

        for (int i = start; i < candidates.length; i++) {
            al.add(candidates[i]);
            helper(candidates, target - candidates[i], start++, al);
            al.remove(al.size() - 1);
        }
    }
}
