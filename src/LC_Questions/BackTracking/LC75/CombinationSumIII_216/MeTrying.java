package LC_Questions.BackTracking.LC75.CombinationSumIII_216;

import java.util.ArrayList;
import java.util.List;

public class MeTrying {

    List<List<Integer>> ans = new ArrayList<>();
    public static void main(String[] args) {
        MeTrying me = new MeTrying();
        int k = 3;
        int n = 9;
        System.out.println(me.combine(k, n));
    }
    public List<List<Integer>> combine(int k, int n) {
        helper(new ArrayList<>(), k,  1, n);
        return ans;
    }
    public void helper (List<Integer> li, int k, int j, int n) {
        if (li.size() == k && n == 0) {
            ans.add(new ArrayList<>(li));
            return;
        }
        for (int i = j; i <= n; i++) {
            li.add(i);
            helper(li, k, i + 1,n - i);
            li.remove(li.size() - 1);
        }
    }
}
