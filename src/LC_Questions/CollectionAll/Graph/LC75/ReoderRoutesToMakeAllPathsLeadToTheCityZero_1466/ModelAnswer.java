package LC_Questions.CollectionAll.Graph.LC75.ReoderRoutesToMakeAllPathsLeadToTheCityZero_1466;

import java.util.ArrayList;
import java.util.List;

public class ModelAnswer {
    boolean [] visited;
    List<List<Integer>> al;

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


    public int helper (int n, int [][] arr) {
        al = new ArrayList<>();
        visited = new boolean[n];
        for (int i = 0; i < n; i++)
            al.add(new ArrayList<>());
        for (int [] a : arr) {
            al.get(a[0]).add(a[1]);
            al.get(a[1]).add(-a[0]);
        }
        return dfs(al,0);
    }

    private int dfs(List<List<Integer>> al, int i) {
        int change = 0;
        for (int to : al.get(i)) {
            if (!visited[Math.abs(to)]) {
                change += dfs (al, Math.abs(to)) + (to > 0 ? 1:0);
            }
        }
        return change;
    }
}
