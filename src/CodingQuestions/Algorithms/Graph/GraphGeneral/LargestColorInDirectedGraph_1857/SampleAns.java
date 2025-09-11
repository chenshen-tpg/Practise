package CodingQuestions.Algorithms.Graph.GraphGeneral.LargestColorInDirectedGraph_1857;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SampleAns {
    public static void main(String[] args) {
        SampleAns solution = new SampleAns();
        String colors = "abaca";
        int[][] edges = {
                {0, 1},
                {0, 2},
                {2, 3},
                {3, 4}
        };
        int result = solution.largestPathValue(colors, edges);
        System.out.println("Largest Path Value: " + result);

    }

    public int largestPathValue(String colors, int[][] edges) {
        char[] cs = colors.toCharArray();
        int n = cs.length;
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        int[] indegree = new int[n];
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            indegree[v]++;
            graph[u].add(v);
        }

        int[][] count = new int[n][26];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        int visited = 0;
        int result = 0;
        while (!q.isEmpty()) {
            ++visited;
            int u = q.poll(), color = cs[u] - 'a';
            result = Math.max(result, ++count[u][color]);
            for (int v : graph[u]) {
                for (int i = 0; i < 26; ++i) {
                    count[v][i] = Math.max(count[v][i], count[u][i]);
                }
                if (--indegree[v] == 0) {
                    q.offer(v);
                }

            }
        }
        return visited == n ? result : -1;
    }
}
