package CodingQuestions.Hash.FindTheNumberOfDistinctColorsAmongTheBalls_3160;

import java.util.HashMap;
import java.util.Map;

public class DoubleHashMap {
    public static void main(String[] args) {

    }

    public int [] method (int [][] queries, int limit) {
        int n = queries.length;
        int[] result = new int[n];
        Map<Integer, Integer> colorMap = new HashMap<>();
        Map<Integer, Integer> ballMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int ball = queries[i][0];
            int color = queries[i][1];
            if (ballMap.containsKey(ball)) {
                int prevColor = ballMap.get(ball);
                colorMap.put(prevColor, colorMap.get(prevColor) - 1);
                if (colorMap.get(prevColor) == 0) {
                    colorMap.remove(prevColor);
                }
            }
            ballMap.put(ball, color);
            colorMap.put(color, colorMap.getOrDefault(color, 0) + 1);
            result[i] = colorMap.size();
        }
        return result;
    }
}
