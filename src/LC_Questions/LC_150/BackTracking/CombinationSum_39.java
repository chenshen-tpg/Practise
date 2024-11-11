package LC_Questions.LC_150.BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum_39 {

    public static void main(String[] args) {
        CombinationSum_39 c = new CombinationSum_39();
        System.out.println(c.combinationSum1(new int[]{2,3,6,7}, 7));
    }

    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        LinkedList<Integer> comb = new LinkedList<Integer>();
        this.backtrack(target, comb, 0, candidates, results);
        return results;
    }
    public void backtrack(int remain,  LinkedList<Integer> comb, int start, int[] candidates, List<List<Integer>> results) {
        if (remain == 0) {
            results.add(new ArrayList<Integer>(comb));
            return;
        } else if (remain < 0) {
            return;
        }
        for (int i = start; i < candidates.length; ++i) {
            comb.add(candidates[i]);
            this.backtrack(remain - candidates[i], comb, i, candidates, results);
            comb.removeLast();
        }
    }



    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>(), new ArrayList<>());
        return result;
    }

    public void helper(int[] candidates, int target, int start, List<Integer> temp, List<List<Integer>> result) {
        int cur = 0;
        for (int i = 0; i < candidates.length; i++) {
            while (target >= cur) {
                cur += candidates[i];
                if (cur == target) {
                    temp.add(candidates[i]);
                    result.add(new ArrayList<>(temp));
                    temp.remove(temp.size() - 1);
                } else if (cur < target) {
                    temp.add(candidates[i]);
                    helper(candidates, target - cur, i, temp, result);
                    temp.remove(temp.size() - 1);
                } else {
                    break;
                }
            }
        }
        result.add(new ArrayList<>(temp));
    }
}
