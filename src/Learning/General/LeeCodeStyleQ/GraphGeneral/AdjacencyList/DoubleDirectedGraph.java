package Learning.General.LeeCodeStyleQ.GraphGeneral.AdjacencyList;

import java.util.*;

public class DoubleDirectedGraph {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 3},
                {1, 4}
        };
        Map<Integer, List<Integer>> adjList = buildAdjList(n, edges);
        DoubleDirectedGraph graph = new DoubleDirectedGraph();
        graph.dfs(adjList);
    }

    public static Map<Integer, List<Integer>> buildAdjList(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        return adjList;
    }
    public void dfs(Map<Integer, List<Integer>> adjList) {
        Set<Integer> visited = new HashSet<>();
        dfsHelper(0, adjList, visited);
        System.out.println("Visited set: " + visited);
    }

    private void dfsHelper(int node, Map<Integer, List<Integer>> adjList, Set<Integer> visited) {
        if (visited.contains(node)) return;
        visited.add(node);
        System.out.println("Visited: " + node);
        for (int neighbor : adjList.get(node)) {
            dfsHelper(neighbor, adjList, visited);
        }
    }
}
