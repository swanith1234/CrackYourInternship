import java.util.*;

class Solution {
    // Method to calculate results for the queries
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Map to store graph representation
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        // Build the graph
        for (int i = 0; i < equations.size(); i++) {
            String A = equations.get(i).get(0);
            String B = equations.get(i).get(1);
            double value = values[i];
            
            graph.putIfAbsent(A, new HashMap<>());
            graph.putIfAbsent(B, new HashMap<>());
            graph.get(A).put(B, value);
            graph.get(B).put(A, 1.0 / value);
        }
        
        // Result array
        double[] results = new double[queries.size()];
        
        // Process each query
        for (int i = 0; i < queries.size(); i++) {
            String C = queries.get(i).get(0);
            String D = queries.get(i).get(1);
            
            // If either variable does not exist in the graph
            if (!graph.containsKey(C) || !graph.containsKey(D)) {
                results[i] = -1.0;
            } else {
                Set<String> visited = new HashSet<>();
                results[i] = dfs(graph, C, D, 1.0, visited);
            }
        }
        
        return results;
    }
    
    // DFS to find the value of C / D
    private double dfs(Map<String, Map<String, Double>> graph, String current, String target, double currentProduct, Set<String> visited) {
        // If the current node is the target, return the accumulated product
        if (current.equals(target)) {
            return currentProduct;
        }
        
        visited.add(current);
        
        // Visit all neighbors
        for (Map.Entry<String, Double> neighbor : graph.get(current).entrySet()) {
            if (!visited.contains(neighbor.getKey())) {
                double result = dfs(graph, neighbor.getKey(), target, currentProduct * neighbor.getValue(), visited);
                if (result != -1.0) {
                    return result;
                }
            }
        }
        
        return -1.0;
    }
}
