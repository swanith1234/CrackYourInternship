import java.util.*;

class Solution {
    private int time = 0;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer>[] graph = new ArrayList[n];
        
        // Initialize the graph as an adjacency list
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // Build the graph from the connections
        for (List<Integer> connection : connections) {
            int u = connection.get(0);
            int v = connection.get(1);
            graph[u].add(v);
            graph[v].add(u);
        }
        
        // Arrays to store the discovery time and the lowest point reachable
        int[] discoveryTime = new int[n];
        int[] lowestTime = new int[n];
        boolean[] visited = new boolean[n];
        
        // Start DFS from node 0
        dfs(0, -1, graph, discoveryTime, lowestTime, visited, result);
        
        return result;
    }
    
    private void dfs(int u, int parent, List<Integer>[] graph, int[] discoveryTime, int[] lowestTime, boolean[] visited, List<List<Integer>> result) {
        visited[u] = true;
        discoveryTime[u] = lowestTime[u] = ++time;
        
        for (int v : graph[u]) {
            if (v == parent) continue;  // Skip the edge that leads back to the parent node
            
            if (!visited[v]) {
                dfs(v, u, graph, discoveryTime, lowestTime, visited, result);
                
                // Check if the current node can reach an ancestor
                lowestTime[u] = Math.min(lowestTime[u], lowestTime[v]);
                
                // If the lowest point reachable from v is higher than discovery time of u, it's a bridge
                if (lowestTime[v] > discoveryTime[u]) {
                    result.add(Arrays.asList(u, v));
                }
            } else {
                // Update the lowest time for u considering back edge to an already visited node
                lowestTime[u] = Math.min(lowestTime[u], discoveryTime[v]);
            }
        }
    }
}
