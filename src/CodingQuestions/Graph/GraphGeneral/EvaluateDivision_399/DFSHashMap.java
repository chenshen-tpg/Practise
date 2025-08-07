package CodingQuestions.Graph.GraphGeneral.EvaluateDivision_399;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class DFSHashMap {
    HashSet<String> vis;
    public static void main(String[] args) {
        DFSHashMap solver = new DFSHashMap();
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
}
