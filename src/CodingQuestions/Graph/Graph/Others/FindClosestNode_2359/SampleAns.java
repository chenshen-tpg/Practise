package CodingQuestions.Graph.Graph.Others.FindClosestNode_2359;

import java.util.Arrays;

public class SampleAns {
    public static void main(String[] args) {

    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        Arrays.fill(dist1,-1);
        dist1[node1] = 0;
        int cur = node1;
        while(edges[cur] != -1 && dist1[edges[cur]] == -1) {
            dist1[edges[cur]] = dist1[cur]+1;
            cur = edges[cur];
        }
        int ans = -1, curMax = Integer.MAX_VALUE;
        int[] dist2 = new int[n];
        Arrays.fill(dist2,-1);
        dist2[node2] = 0;
        cur = node2;
        if(dist1[cur]>=0) {
            ans = cur;
            curMax = dist1[cur];
        }
        while(edges[cur] != -1 && dist2[edges[cur]] == -1) {
            dist2[edges[cur]] = dist2[cur]+1;
            cur = edges[cur];
            if(dist1[cur]>=0) {
                if(curMax>Math.max(dist1[cur],dist2[cur])) {
                    curMax = Math.max(dist1[cur],dist2[cur]);
                    ans = cur;
                } else if(curMax==Math.max(dist1[cur],dist2[cur]) && ans>cur) {
                    ans = cur;
                }
            }
        }
        return ans;
    }
}
