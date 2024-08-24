import java.util.*;

class Solution {
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[V]; // Array to store color assignment
        Arrays.fill(color, -1); // Initialize all vertices as uncolored
        
        // We may have a disconnected graph, so we need to check each component
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) { // If the vertex is not colored
                if (!bfsCheck(i, adj, color)) {
                    return false; // If any component isn't bipartite, return false
                }
            }
        }
        
        return true; // All components are bipartite
    }
    
    private boolean bfsCheck(int start, ArrayList<ArrayList<Integer>> adj, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 0; // Start coloring with 0
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            for (int neighbor : adj.get(node)) {
                if (color[neighbor] == -1) { // If the neighbor is not colored
                    color[neighbor] = 1 - color[node]; // Color with opposite color
                    queue.add(neighbor);
                } else if (color[neighbor] == color[node]) { // If the neighbor is colored with the same color
                    return false; // The graph is not bipartite
                }
            }
        }
        
        return true; // Successfully colored, hence bipartite
    }
}
