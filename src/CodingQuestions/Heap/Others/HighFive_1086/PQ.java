package CodingQuestions.Heap.Others.HighFive_1086;

import java.util.HashMap;
import java.util.PriorityQueue;

public class PQ {
    public static void main(String[] args) {

        int[][] items = {{1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60}, {2, 77}, {1, 65}, {1, 87}, {1, 100}, {2, 100}, {2, 76}};
        highFive(items);
    }

    public static int[][] highFive(int[][] items) {
        HashMap<Integer, PriorityQueue<Integer>> hm = new HashMap<>();
        for (int i = 0; i < items.length; i++) {
            if (!hm.containsKey(items[i][0])) hm.put(items[i][0], new PriorityQueue<>((a, b) -> b - a));
            hm.get(items[i][0]).add(items[i][1]);
        }
        // one line solution
        // for (int[] item : items) hm.computeIfAbsent(item[0], k -> new PriorityQueue<>((a, b) -> b - a)).add(item[1]);
        int [][] res = new int [hm.size()][2];
        int index = 0;
        for (Integer m : hm.keySet()) {
            int count = 0;
            int temp = 0;
            while (hm.get(m) != null && count < 5) {
                temp += hm.get(m).poll();
                count++;
            }
            int [] TempAns = new int [] {m, temp / 5};
            res[index++] = TempAns;
        }
        return res;
    }
}
