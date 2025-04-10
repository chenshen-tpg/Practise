package LC_Questions.Array.BackTracking.LC150.Combination_77;

import java.util.ArrayList;
import java.util.List;

public class Backtracking {
    public static void main(String[] args) {
        Backtracking c = new Backtracking();
        System.out.println(c.start(4, 2));
    }

    public List<List<Integer>> start(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        helper(1, n, k, new ArrayList<>(), result);
        return result;
    }
    // two issues, starting from 1,2,3,4...n, and the length of the combination is k
    public void helper(int start, int end, int len, List<Integer> temp, List<List<Integer>> result) {
        if (temp.size() == len) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= end; i++) {
            temp.add(i);
            helper(i + 1, end, len, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
}
