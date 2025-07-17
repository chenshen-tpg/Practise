package CodingQuestions.Array.BackTracking.Others.CombinationSumII_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursiveArr {
    public static void main(String[] args) {

    }
    ArrayList<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<Integer>());
        return res;
    }
    public void helper (int [] candidates, int start, int target, ArrayList<Integer> li) {
        if (target == 0) {
            res.add(new ArrayList<>(li));
        }
        else if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            li.add(candidates[i]);
            helper(candidates, i + 1, target - candidates[i], li);
            li.remove(li.size() - 1);
        }
    }

}
