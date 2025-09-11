package CodingQuestions.Algorithms.Graph.GraphGeneral.ReoderRoutesToMakeAllPathsLeadToTheCityZero_1466;

import java.util.ArrayList;
import java.util.List;

public class Review {
    boolean [] visited;
    List<List<Integer>> al;
    public static void main(String[] args) {
        Review r  = new Review();
        int n1 = 6;
        int[][] connections1 = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        System.out.println(r.helper(n1, connections1)); // Expected output: 3

    }
    public int helper (int n, int [][] arr) {
        visited = new boolean [n];
        al = new ArrayList<>();
        for (int i = 0; i < n; i++) al.add(new ArrayList<>());
        for (int [] a : arr) {
            al.get(a[0]).add(a[1]);
            al.get(a[1]).add(-a[0]);
        }
        return dfs(al,0);
    }

    private int dfs(List<List<Integer>> al, int i) {
        int change = 0;
        visited[i] = true;
        for (int outwards : al.get(i)) {
            if (!visited[Math.abs(outwards)]) {
                change += dfs(al, Math.abs(outwards)) + (outwards > 0 ? 1 : 0);
            }
        }
        return change;
    }
}
