package LC_Questions.WholePackage.Intervals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class MergeIntervals_56 {


    public static Map<int[], List<int[]>> graph;
    public static Map<Integer, List<int[]>> nodesInComp;
    public static Set<int[]> visited;
    public static void main(String[] args) {
        MergeIntervals_56 mi = new MergeIntervals_56();
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        mi.merge1(intervals);
    }
    public int[][] merge1(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> m = new LinkedList<>();
        for (int[] interval : intervals) {
            if (m.isEmpty() || m.getLast()[1] < interval[0]) {
                m.add(interval);
            } else {
                m.getLast()[1] = Math.max(m.getLast()[1], interval[1]);
            }
        }
        return m.toArray(new int[m.size()][]);
    }
    private int[] mergeNodes(List<int[]> nodes) {
        int minStart = nodes.get(0)[0];
        for (int[] node : nodes) {
            minStart = Math.min(minStart, node[0]);
        }

        int maxEnd = nodes.get(0)[1];
        for (int[] node : nodes) {
            maxEnd = Math.max(maxEnd, node[1]);
        }

        return new int[] { minStart, maxEnd };
    }
    private void markComponentDFS(int[] start, int compNumber) {
        Stack<int[]> stack = new Stack<>();
        stack.add(start);
        while (!stack.isEmpty()) {
            int[] node = stack.pop();
            if (!visited.contains(node)) {
                visited.add(node);
                if (nodesInComp.get(compNumber) == null) {
                    nodesInComp.put(compNumber, new LinkedList<>());
                }
                nodesInComp.get(compNumber).add(node);
                for (int[] child : graph.get(node)) {
                    stack.add(child);
                }
            }
        }
    }
    private boolean overlap(int[] a, int[] b) {
        return a[0] <= b[1] && b[0] <= a[1];
    }
    public int[][] merge(int[][] intervals) {
        graph = new HashMap<>();
        for (int[] interval : intervals) {
            graph.put(interval, new LinkedList<>());
        }
        for (int[] interval1 : intervals) {
            for (int[] interval2 : intervals) {
                if (overlap(interval1, interval2)) {
                    graph.get(interval1).add(interval2);
                    graph.get(interval2).add(interval1);
                }
            }
        }
        nodesInComp = new HashMap<>();
        visited = new HashSet<>();
        int compNumber = 0;
        for (int[] interval : intervals) {
            if (!visited.contains(interval)) {
                markComponentDFS(interval, compNumber);
                compNumber++;
            }
        }
        List<int[]> merged = new LinkedList<>();
        for (int comp = 0; comp < nodesInComp.size(); comp++) {
            merged.add(mergeNodes(nodesInComp.get(comp)));
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
