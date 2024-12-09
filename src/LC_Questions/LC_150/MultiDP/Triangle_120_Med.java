package LC_Questions.LC_150.MultiDP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Triangle_120_Med {
    public static void main(String[] args) {
        Triangle_120_Med t = new Triangle_120_Med();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(List.of(2)));
        triangle.add(new ArrayList<>(List.of(3, 4)));
        triangle.add(new ArrayList<>(List.of(6, 5, 7)));
        triangle.add(new ArrayList<>(List.of(4, 1, 8, 3)));
        System.out.println(t.minimumTotal(triangle));
    }
    public int minimumTotal(List<List<Integer>> t) {
        for (int row = 1; row < t.size(); row++) {
            for (int col = 0; col <= row; col++) {
                int s = Integer.MAX_VALUE;
                if (col > 0) s = t.get(row-1).get(col-1);
                if (col < row) s = Math.min(s,t.get(row-1).get(col));
                int path = s + t.get(row).get(col);
                t.get(row).set(col, path);
            }
        }
        return Collections.min(t.getLast());
    }
}
