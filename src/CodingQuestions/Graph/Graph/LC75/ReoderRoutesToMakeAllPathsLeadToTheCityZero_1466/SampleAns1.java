package CodingQuestions.Graph.Graph.LC75.ReoderRoutesToMakeAllPathsLeadToTheCityZero_1466;

import java.util.ArrayList;
import java.util.List;

public class SampleAns1 {
    public static void main(String[] args) {

    }
    List<int[]>[] graph;
    boolean[] seen;
    public int minReorder(int n, int[][] connections) {
        graph = new ArrayList[n];
        for(int i = 0; i< n; i++){
            graph[i]= new ArrayList<>();
        }
        for(int[] e : connections){
            graph[e[0]].add(new int[]{e[1],1});
            graph[e[1]].add(new int[]{e[0],0});
        }
        seen = new boolean[n];
        return dfs(0);
    }

    public int dfs(int u){
        seen[u] = true;
        int res = 0;
        for(int[] dot : graph[u]){
            int v = dot[0], e = dot[1];
            if(!seen[v]){
                res += e + dfs(v);
            }

        }
        return res;
    }
}
