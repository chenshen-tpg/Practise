package CodingQuestions.Algorithms.Graph.GraphGeneral.FindMinimumTime_3341;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Model {
    class Node implements Comparable<Node> {
        int id;
        int distance;

        public Node(int id, int distance) {
            this.id = id;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }
    public static void main(String[] args) {
        // Example graph (adjacency list: node -> list of {neighbor, weight})
        Map<Integer, List<int[]>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(new int[]{1, 4}, new int[]{2, 2}));
        graph.put(1, Arrays.asList(new int[]{0, 4}, new int[]{2, 1}, new int[]{3, 5}));
        graph.put(2, Arrays.asList(new int[]{0, 2}, new int[]{1, 1}, new int[]{3, 8}));
        graph.put(3, Arrays.asList(new int[]{1, 5}, new int[]{2, 8}));

        Model dijkstra = new Model();
        int sourceNode = 0;
        Map<Integer, Integer> shortestPaths = dijkstra.findShortestPaths(graph, sourceNode);

        System.out.println("Shortest paths from node " + sourceNode + ":");
        for (Map.Entry<Integer, Integer> entry : shortestPaths.entrySet()) {
            System.out.println("To node " + entry.getKey() + ": " + entry.getValue());
        }
    }

    public Map<Integer, Integer> findShortestPaths(Map<Integer, List<int[]>> graph, int source) {
        Map<Integer, Integer> distances = new HashMap<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        Set<Integer> visited = new HashSet<>();

        // Initialize distances
        for (int node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(source, 0);
        minHeap.add(new Node(source, 0));

        while (!minHeap.isEmpty()) {
            Node current = minHeap.poll();
            int u = current.id;

            if (visited.contains(u)) {
                continue;
            }
            visited.add(u);

            if (graph.containsKey(u)) {
                for (int[] neighborInfo : graph.get(u)) {
                    int v = neighborInfo[0];
                    int weight = neighborInfo[1];
                    int newDistance = distances.get(u) + weight;
                    if (newDistance < distances.get(v)) {
                        distances.put(v, newDistance);
                        minHeap.add(new Node(v, newDistance));
                    }
                }
            }
        }
        return distances;
    }

}
