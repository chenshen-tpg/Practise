package CodingQuestions.Graph.Graph.Others.MinimumCostWalking_3108;

import java.util.Arrays;

public class UnionFindTest {
    public static void main(String[] args) {
        int[] parent = {0, 1, 2, 3, 4};
        UnionFindTest solution = new UnionFindTest();
        solution.union(parent, 0, 1);
        solution.union(parent, 1, 2);
        solution.union(parent, 3, 4);
        //0 -> 2, 3 -> 4
        System.out.println("Root of 2: " + solution.findRoot(parent, 2)); // Output: 0
        System.out.println("Root of 4: " + solution.findRoot(parent, 4)); // Output: 3
        System.out.println("Parent array: " + Arrays.toString(parent)); // Output: [0, 0, 0, 3, 3]
    }

    private void union(int[] parent, int node1, int node2) {
        int root1 = findRoot(parent, node1);
        int root2 = findRoot(parent, node2);
        if (root1 != root2) {
            parent[root2] = root1;
        }
    }

    private int findRoot(int[] parent, int node) {
        if (parent[node] != node) parent[node] = findRoot(parent, parent[node]);
        return parent[node];
    }
}
