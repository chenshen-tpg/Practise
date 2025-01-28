package LC_Questions.CollectionAll.LinkedList.Others;

import java.util.ArrayList;
import java.util.List;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero_1466 {
    public static void main(String[] args) {
        int n = 6;
        int [][] connections = {{0,1},{1,3},{2,3},{4,0},{4,5}};
        minReorder(n,connections);
    }
    public static int dfs(List<List<Integer>> al, boolean[] visited, int from) {
        int change = 0;
        visited[from] = true;
        for (int to : al.get(from))
            if (!visited[Math.abs(to)])
                change += dfs(al, visited, Math.abs(to)) + (to > 0 ? 1 : 0);
        return change;
    }
    public static int minReorder(int n, int[][] connections) {
        List<List<Integer>> al = new ArrayList<>();
        for(int i = 0; i < n; ++i)
            al.add(new ArrayList<>());
        for (int[] c : connections) {
            al.get(c[0]).add(c[1]);
            al.get(c[1]).add(-c[0]);
        }
        return dfs(al, new boolean[n], 0);
    }
}
