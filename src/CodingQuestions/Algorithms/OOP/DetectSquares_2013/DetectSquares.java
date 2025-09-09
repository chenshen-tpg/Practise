package CodingQuestions.Algorithms.OOP.DetectSquares_2013;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DetectSquares {
    List<int[]> coordinates;
    Map<String, Integer> counts;
    public static void main(String[] args) {

        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[]{3, 10});
        detectSquares.add(new int[]{11, 2});
        detectSquares.add(new int[]{3, 2});
        System.out.println("Test case 1: " + detectSquares.count(new int[]{11, 10}));
        detectSquares.add(new int[]{1, 1});
        detectSquares.add(new int[]{1, 2});
        detectSquares.add(new int[]{2, 1});
        detectSquares.add(new int[]{2, 2});
        System.out.println("Test case 2: " + detectSquares.count(new int[]{1, 1}));
    }
    public DetectSquares() {
        coordinates = new ArrayList<>();
        counts = new HashMap<>();
    }

    public void add(int[] point) {
        coordinates.add(point);
        String key = point[0] + "," + point[1];
        counts.put(key, counts.getOrDefault(key, 0) + 1);
    }

    public int count(int[] point) {
        int sum = 0, px = point[0], py = point[1];
        for (int[] coordinate : coordinates) {
            int x = coordinate[0], y = coordinate[1];
            if (px == x || py == y || (Math.abs(px - x) != Math.abs(py - y))) continue;
            sum += counts.getOrDefault(x + "," + py, 0) * counts.getOrDefault(px + "," + y, 0);
        }
        return sum;
    }
}
