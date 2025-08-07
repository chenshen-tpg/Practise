package CodingQuestions.Graph.GraphGeneral.PascalTriangleII_119;

import java.util.ArrayList;
import java.util.List;

public class DP {
    public static void main(String[] args) {

    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList(rowIndex + 1) {{add(1);}};

        for (int i = 0; i < rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            row.add(1);
        }
        return row;
    }
}
