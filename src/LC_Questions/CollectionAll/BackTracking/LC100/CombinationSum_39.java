package LC_Questions.CollectionAll.BackTracking.LC100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum_39 {
    List<List<Integer>> results;
    public static void main(String[] args) {
        CombinationSum_39 c = new CombinationSum_39();
        System.out.println(c.combinationSum1(new int[]{2,3,6,7}, 7));
    }

    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        results = new ArrayList<List<Integer>>();
        LinkedList<Integer> comb = new LinkedList<Integer>();
        this.backtrack(target, comb, 0, candidates);
        return results;
    }
    public void backtrack(int remain, LinkedList<Integer> comb, int start, int[] candidates) {
        if (remain == 0) {
            results.add(new ArrayList<Integer>(comb));
            return;
        } else if (remain < 0) {
            return;
        }
        for (int i = start; i < candidates.length; ++i) {
            comb.add(candidates[i]);
            this.backtrack(remain - candidates[i], comb, i, candidates);
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
                    // still need's to remove
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
