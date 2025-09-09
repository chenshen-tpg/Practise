package CodingQuestions.Algorithms.Hash.FindTheNumberOfDistinctColorsAmongTheBalls_3160;

import java.util.HashMap;
import java.util.Map;

public class review {
    public static void main(String[] args) {

    }

    public int [] doubleHashMap (int [][] queries) {
        int n = queries.length;
        int [] result = new int [n];
        Map<Integer, Integer> colors = new HashMap<>();
        Map<Integer, Integer> balls = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int colour = queries[i][1];
            if (balls.containsKey(ball)) {
                int preCol = balls.get(ball);
                colors.put(preCol, colors.get(preCol) - 1);
                if (colors.get(preCol) == 0) colors.remove(preCol);
            }
            balls.put(ball, colour);
            colors.put(colour, colors.getOrDefault(colour, 0) + 1);
            result[i] = colors.size();
        }
        return result;
    }
}
