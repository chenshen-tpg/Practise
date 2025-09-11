package CodingQuestions.Algorithms.Graph.GraphGeneral.MinimumCostWalking_3108;

import java.util.Arrays;

public class Union {

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1, 7}, {1, 3, 7}, {1, 2, 1}};
        int[][] query = {{0, 3}, {3, 4}};
        Union union = new Union();
        int[] result = union.minimumCost(n, edges, query);
        System.out.println(Arrays.toString(result));
        // Output: [1, -1]
    }


    private int findRoot(int[] parent, int node) {
        if (parent[node] != node) parent[node] = findRoot(parent, parent[node]);
        return parent[node];
    }

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int[] parent = new int[n];
        int[] minPathCost = new int[n];
        Arrays.fill(minPathCost, -1);
        for (int i = 0; i < n; i++) parent[i] = i;
        for (int[] edge : edges) {
            int source = edge[0], target = edge[1], weight = edge[2];
            int sourceRoot = findRoot(parent, source);
            int targetRoot = findRoot(parent, target);
            minPathCost[targetRoot] &= weight;
            if (sourceRoot != targetRoot) {
                minPathCost[targetRoot] &= minPathCost[sourceRoot];
                parent[sourceRoot] = targetRoot;
            }
        }
        int[] result = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int start = query[i][0], end = query[i][1];
            if (start == end) result[i] = 0;
            else if (findRoot(parent, start) != findRoot(parent, end)) result[i] = -1;
            else result[i] = minPathCost[findRoot(parent, start)];
        }
        return result;
    }
}
