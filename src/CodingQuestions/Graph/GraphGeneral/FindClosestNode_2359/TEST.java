package CodingQuestions.Graph.GraphGeneral.FindClosestNode_2359;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TEST {
    public static void main(String[] args) {

    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int [] memo1 = new int [n];
        int [] memo2 = new int [n];
        Arrays.fill(memo1, Integer.MAX_VALUE);
        Arrays.fill(memo2, Integer.MAX_VALUE);
        bfs(node1, edges, memo1);
        bfs(node2, edges, memo2);
        int res = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = Math.max(memo1[i], memo2[i]);
            if (min > temp) {
                res = i;
                min = temp;
            }
        }
        return res;
    }

    private void bfs(int start, int[] edges, int[] memo) {
        int n = edges.length;
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        Boolean [] vis = new Boolean[n];
        Arrays.fill(vis, false);
        memo[start] = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (vis[cur]) {
                continue;
            }
            vis[cur] = true;
            int nei = edges[cur];
            if (nei != -1 && !vis[nei]) {
                memo[nei] = 1 + memo[cur];
                q.offer(nei);
            }
        }
    }
}
