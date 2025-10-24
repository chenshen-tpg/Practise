package Preparation.General.LeeCodeStyleQ.DFS.GraphValidTree_261;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class test {
    List<List<Integer>> li = new ArrayList();
    private final Set<Integer> memo = new HashSet<>();

    public static void main(String[] args) {
    }

    //    Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
//    Output: true
    public boolean method1(int[][] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            li.add(new ArrayList<>());
        }
        for (int i = 0; i < arr.length; i++) {
            int row = arr[i][0];
            int col = arr[i][1];
            li.get(row).add(col);
            li.get(col).add(row);
        }
        dfs(0);
        return memo.size() == n;
    }

    public void dfs(int node) {
        if (memo.contains(node)) return;
        memo.add(node);
        for (int l : li.get(node)) {
            dfs(l);
        }
    }
}
