package LC_Questions.DP.Others.Triangle_120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BUDP {
    public static void main(String[] args) {
        BUDP t = new BUDP();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(Arrays.asList(2)));
        triangle.add(new ArrayList<>(Arrays.asList(3, 4)));
        triangle.add(new ArrayList<>(Arrays.asList(6, 5, 7)));
        triangle.add(new ArrayList<>(Arrays.asList(4, 1, 8, 3)));
        System.out.println(t.minimumTotal(triangle));
    }
    public int minimumTotal(List<List<Integer>> t) {
        for (int row = 1; row < t.size(); row++) {
            for (int col = 0; col <= row; col++) {
                int s = Integer.MAX_VALUE;
                if (col > 0) {
                    s = t.get(row - 1).get(col - 1);
                }
                if (col < row) {
                    s = Math.min(s, t.get(row - 1).get(col));
                }
                int path = s + t.get(row).get(col);
                t.get(row).set(col, path);
            }
        }
        return Collections.min(t.get(t.size() - 1));
    }
}
