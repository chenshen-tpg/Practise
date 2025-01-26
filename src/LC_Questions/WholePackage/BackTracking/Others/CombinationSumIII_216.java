package LC_Questions.WholePackage.BackTracking.Others;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII_216
{
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), k, n, 1);
        return res;
    }

    public static void backtrack(List<List<Integer>> res, List<Integer> temp, int k, int n, int start) {
        if (temp.size() == k && n == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= 9; i++) {
            temp.add(i);
            backtrack(res, temp, k, n - i, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
