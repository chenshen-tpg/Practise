package LC_Questions.OOP.Others.DetectSquares_2013;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Review {
    List<int[]> li;
    Map<String, Integer> mp;
    public static void main(String[] args) {

        Review solution = new Review();
        solution.add(new int[]{3, 10});
        solution.add(new int[]{11, 2});
        solution.add(new int[]{3, 2});
        System.out.println("Test case 1: " + solution.count(new int[]{11, 10}));
        solution.add(new int[]{1, 1});
        solution.add(new int[]{1, 2});
        solution.add(new int[]{2, 1});
        solution.add(new int[]{2, 2});
        System.out.println("Test case 2: " + solution.count(new int[]{1, 1}));
    }
    public Review() {
        mp = new HashMap();
        li = new ArrayList();
    }

    public void add(int[] point) {
        // adding one...
        mp.put(point[0] + "," + point[1], mp.getOrDefault(point[0] + "," + point[1], 0) + 1);
        li.add(point);
    }

    public int count(int[] point) {
        int ans = 0;
        for (int[] l : li) {
            if (l[0] == point[0] || l[1] == point[1] || Math.abs(l[0] - point[0]) != Math.abs(l[1] - point[1]))
                continue;
            ans += mp.getOrDefault(point[0] + "," + l[1], 0) * mp.getOrDefault(l[0] + "," + point[1], 0);
        }
        return ans;
    }
}
