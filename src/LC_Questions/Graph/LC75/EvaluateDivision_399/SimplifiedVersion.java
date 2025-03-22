package LC_Questions.Graph.LC75.EvaluateDivision_399;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SimplifiedVersion {
    public static void main(String[] args) {

    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String dividend = queries.get(i).get(0);
            String divisor = queries.get(i).get(1);
            if (!graph.containsKey(dividend) || !graph.containsKey(divisor)) results[i] = -1.0;
            else results[i] = dfs(graph, dividend, divisor, new HashSet<>(), 1.0);
        }
        return results;
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String dividend = equations.get(i).get(0);
            String divisor = equations.get(i).get(1);
            double value = values[i];
            graph.computeIfAbsent(dividend, k -> new HashMap<>()).put(divisor, value);
            graph.computeIfAbsent(divisor, k -> new HashMap<>()).put(dividend, 1.0 / value);
        }
        return graph;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String current, String target, Set<String> visited, double value) {
        if (visited.contains(current)) return -1.0;
        visited.add(current);
        if (current.equals(target)) return value;
        if (!graph.containsKey(current)) return -1.0;
        for (Map.Entry<String, Double> neighbor : graph.get(current).entrySet()) {
            double result = dfs(graph, neighbor.getKey(), target, visited, value * neighbor.getValue());
            if (result != -1.0) return result;
        }
        return -1.0;
    }
}
