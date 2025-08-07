package CodingQuestions.Graph.GraphGeneral.PascalTriangleII_119;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TEST {
    public static void main(String[] args) {

    }
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex <= 0) return new ArrayList<>(Arrays.asList(1));
        List<List<Integer>> pascal = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            res = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) res.add(1);
                else res.add(pascal.get(i - 1).get(j - 1) + pascal.get(i - 1).get(j));
            }
            pascal.add(res);
        }
        return res;
    }
}
