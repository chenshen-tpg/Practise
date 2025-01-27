package LC_Questions.CollectionAll.Graph.LC75.ReoderRoutesToMakeAllPathsLeadToTheCityZero_1466;

import java.util.ArrayList;
import java.util.List;

public class DFSList {
    public static void main(String[] args) {
        DFSList d = new DFSList();
        int n1 = 6;
        int[][] connections1 = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        System.out.println(d.minReorder(n1, connections1)); // Expected output: 3

        // Test case 2
        int n2 = 5;
        int[][] connections2 = {{1, 0}, {1, 2}, {3, 2}, {3, 4}};
        System.out.println(d.minReorder(n2, connections2));
    }
    public int dfs(List<List<Integer>> al, boolean[] visited, int from) {
        int change = 0;
        visited[from] = true;

        for (int to : al.get(from))
            // 0 (1,-4)
            if (!visited[Math.abs(to)])
                // 1,4 not visited
                // so finding 1,4 and because 1 > 0(going outward), add 1 to the result.
                change += dfs(al, visited, Math.abs(to)) + (to > 0 ? 1 : 0);
        return change;
    }
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i < n; i++) al.add(new ArrayList<>());
        for (int[] c : connections) {
            al.get(c[0]).add(c[1]);
            al.get(c[1]).add(-c[0]);
        }
        // getting 0(1, -4), 1(0, 3), 2(3), 3(-1, -2), 4(0, 5), 5(-4)
        return dfs(al, new boolean[n], 0);
    }
}
