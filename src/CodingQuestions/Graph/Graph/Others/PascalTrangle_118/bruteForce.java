package CodingQuestions.Graph.Graph.Others.PascalTrangle_118;

import java.util.ArrayList;
import java.util.List;

public class bruteForce {
    public static void main(String[] args) {
        System.out.println(helper(5));
    }
    public static List<List<Integer>> helper(int numRows) {
        if (numRows <= 0) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i ; j++) {
                if (j == 0 || j == i) row.add(1);
                else row.add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
            }
            ans.add(row);
        }
        return ans;
    }
}
