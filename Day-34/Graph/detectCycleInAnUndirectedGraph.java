import java.util.*;

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        
        // Check for each vertex, as the graph can be disconnected
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                // If cycle is found in any component, return true
                if (dfs(i, -1, visited, adj)) {
                    return true;
                }
            }
        }
        // If no cycle is found in any component, return false
        return false;
    }
    
    private boolean dfs(int node, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;
        
        // Traverse all adjacent vertices of the current vertex
        for (Integer neighbor : adj.get(node)) {
            // If neighbor is not visited, recursively visit it
            if (!visited[neighbor]) {
                if (dfs(neighbor, node, visited, adj)) {
                    return true;
                }
            } 
            // If neighbor is visited and is not the parent, we found a cycle
            else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }
}
