package LC_Questions.CollectionAll.Graph.LC75.EvaluateDivision_399_Review;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class DFSHashMap {
    HashSet<String> vis;
    public static void main(String[] args) {
        DFSHashMap solver = new DFSHashMap();

        // Example 1
        List<List<String>> equations1 = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c")
        );
        double[] values1 = {2.0, 3.0};
        List<List<String>> queries1 = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "e"),
                Arrays.asList("a", "a"),
                Arrays.asList("x", "x")
        );
        System.out.println(Arrays.toString(solver.calcEquation(equations1, values1, queries1))); // Expected output: [6.0, 0.5, -1.0, 1.0, -1.0]

        // Example 2
        List<List<String>> equations2 = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c"),
                Arrays.asList("bc", "cd")
        );
        double[] values2 = {1.5, 2.5, 5.0};
        List<List<String>> queries2 = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("c", "b"),
                Arrays.asList("bc", "cd"),
                Arrays.asList("cd", "bc")
        );
        System.out.println(Arrays.toString(solver.calcEquation(equations2, values2, queries2))); // Expected output: [3.75, 0.4, 5.0, 0.2]

        // Example 3
        List<List<String>> equations3 = Arrays.asList(
                Arrays.asList("a", "b")
        );
        double[] values3 = {0.5};
        List<List<String>> queries3 = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "c"),
                Arrays.asList("x", "y")
        );
        System.out.println(Arrays.toString(solver.calcEquation(equations3, values3, queries3))); // Expected output: [0.5, 2.0, -1.0, -1.0]
    }


    public void dfs(String node, String dest, HashMap<String, HashMap<String, Double>> gr, double[] ans, double temp) {
        if (vis.contains(node))  return;
        vis.add(node);
        if (node.equals(dest)) {
            ans[0] = temp;
            return;
        }

        for (Map.Entry<String, Double> entry : gr.get(node).entrySet()) {
            String ne = entry.getKey();
            double val = entry.getValue();
            dfs(ne, dest, gr, ans, temp * val);
        }
    }

    public HashMap<String, HashMap<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        HashMap<String, HashMap<String, Double>> hm = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            double value = values[i];
            hm.putIfAbsent(dividend, new HashMap<>());
            hm.putIfAbsent(divisor, new HashMap<>());
            hm.get(dividend).put(divisor, value);
            hm.get(divisor).put(dividend, 1.0 / value);
        }
        return hm;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> gr = buildGraph(equations, values);
        double[] finalAns = new double[queries.size()];
        vis = new HashSet<>();
        for (int i = 0; i < queries.size(); i++) {
            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);
            if (!gr.containsKey(dividend) || !gr.containsKey(divisor)) {
                finalAns[i] = -1.0;
            } else {
                vis = new HashSet<>();
                double[] ans = {-1.0};
                double temp = 1.0;
                dfs(dividend, divisor, gr, ans, temp);
                finalAns[i] = ans[0];
            }
        }
        return finalAns;
    }
}
