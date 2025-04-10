package LC_Questions.Array.BackTracking.LC75.CombinationSumIII_216;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    List<List<Integer>> ans = new ArrayList<>();
    public static void main(String[] args) {
        int k = 3;
        int n = 9;
        System.out.println(new DFS().combinationSum3(k, n));
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(new ArrayList<>(), k, 1, n);
        return ans;
    }

    public void helper(List<Integer> comb, int k,  int start, int n) {
        if (comb.size() == k && n == 0) {
            List<Integer> li = new ArrayList<>(comb);
            ans.add(li);
            return;
        }
        for (int i = start; i <= n; i++) {
            comb.add(i);
            helper(comb, k, i + 1, n-i);
            comb.remove(comb.size() - 1);
        }
    }
}
