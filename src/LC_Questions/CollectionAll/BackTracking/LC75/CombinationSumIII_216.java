package LC_Questions.CollectionAll.BackTracking.LC75;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII_216 {
    public static void main(String[] args) {
        int k = 3;
        int n = 9;
        System.out.println(new CombinationSumIII_216().combinationSum3(k, n));
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        combination(ans, new ArrayList<>(), k, 1, n);
        return ans;
    }

    public void combination(List<List<Integer>> ans, List<Integer> comb, int k,  int start, int n) {
        if (comb.size() == k && n == 0) {
            List<Integer> li = new ArrayList<>(comb);
            ans.add(li);
            return;
        }
        for (int i = start; i <= 9; i++) {
            comb.add(i);
            combination(ans, comb, k, i+1, n-i);
            comb.removeLast();
        }
    }
}
