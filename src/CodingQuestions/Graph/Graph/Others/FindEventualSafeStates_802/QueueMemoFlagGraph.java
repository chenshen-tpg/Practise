package CodingQuestions.Graph.Graph.Others.FindEventualSafeStates_802;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueMemoFlagGraph {
//    [[1,2,3,4],[1,2],[3,4],[0,4],[]]


    public static void main(String[] args) {
        int [][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        QueueMemoFlagGraph m = new QueueMemoFlagGraph();
        m.eventualSafeNodes(graph);
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        List<List<Integer>> memo = new ArrayList<>();
        int [] indegree = new int[graph.length];
        boolean [] node = new boolean [graph.length];
        for (int i = 0; i < graph.length; i++) memo.add(new ArrayList<>());
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                memo.get(graph[i][j]).add(i);
                indegree[i]++;
            }
        }
        for (int i = 0; i < graph.length; i++) {
            if (indegree[i] == 0) q.add(i);
        }
        while (!q.isEmpty()) {
            int temp = q.poll();
            node[temp] = true;
            for (int m : memo.get(temp)) {
                indegree[m]--;
                if (indegree[m] == 0) q.add(m);
            }
        }
        for (int i = 0; i < graph.length; i++) {
            if (node[i]) res.add(i);
        }
        return res;
    }
}
