package LC_Questions.Graph.Graph.Others.MaximizetheNumberofTargetNodesAfterConnectingTrees_2894;

import java.util.ArrayList;
import java.util.List;

public class TEST {
    public static void main(String[] args) {
            TEST solution = new TEST();
            int[][] edges1 = {
                    {0, 1},
                    {0, 2},
                    {2, 3},
                    {2, 4}
            };
            int[][] edges2 = {
                    {0, 1},
                    {0, 2},
                    {0, 3},
                    {2, 7},
                    {1, 4},
                    {4, 5},
                    {4, 6}
            };

            int k = 2;

            int[] result = solution.maximizeTargetNodes(edges1, edges2, k);
            System.out.println("Maximized Target Nodes: " + result);


        }

    private int[] maximizeTargetNodes(int[][] edges1, int[][] edges2, int k) {
        List<List<Integer>> graph1 = new ArrayList<>();
        List<List<Integer>> graph2 = new ArrayList<>();
        for (int i = 0; i < edges1.length; i++) {
            graph1.add(new ArrayList<>());
        }
        for (int i = 0; i < edges2.length; i++) {
            graph2.add(new ArrayList<>());
        }
        for (int[] g1 : edges1) {
            int u = g1[0];
            int x = g1[1];
            graph1.get(u).add(x);
        }
        for (int[] g2 : edges2) {
            int u = g2[0];
            int x = g2[1];
            graph2.get(u).add(x);
        }

        return new int[]{};
    }


}
