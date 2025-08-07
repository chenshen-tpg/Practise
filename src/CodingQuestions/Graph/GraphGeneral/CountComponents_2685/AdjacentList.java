package CodingQuestions.Graph.GraphGeneral.CountComponents_2685;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacentList {
    public static void main(String[] args) {
            int n = 6;
            int[][] edges = {
                    {0, 1},
                    {0, 2},
                    {1, 2},
                    {3, 4},
                    {3, 5}
            };
            AdjacentList solution = new AdjacentList();
            int result = solution.countCompleteComponents(n, edges);
            System.out.println("Number of complete components: " + result);
    }

    public int countCompleteComponents(int n, int[][] edges) {
        int res = 0;
        List<Integer>[] graph = new ArrayList[n];
        Map<List<Integer>, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            graph[i].add(i);
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            List<Integer> neighbors = graph[i];
            Collections.sort(neighbors);
            hm.put(neighbors, hm.getOrDefault(neighbors, 0) + 1);
        }
        for (Map.Entry<List<Integer>, Integer> entry : hm.entrySet()) {
            if (entry.getKey().size() == entry.getValue()) {
                res++;
            }
        }
        return res;
    }
}
