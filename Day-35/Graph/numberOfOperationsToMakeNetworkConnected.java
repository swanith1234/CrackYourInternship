import java.util.*;

class Solution {
    public int makeConnected(int n, int[][] connections) {
        // Step 1: Check if there are enough connections
        if (connections.length < n - 1) {
            return -1;
        }

        // Step 2: Build the adjacency list
        List<Integer>[] adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int[] connection : connections) {
            adjList[connection[0]].add(connection[1]);
            adjList[connection[1]].add(connection[0]);
        }

        // Step 3: Count the number of connected components using DFS
        boolean[] visited = new boolean[n];
        int components = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;
                dfs(i, adjList, visited);
            }
        }

        // Step 4: The minimum number of operations required is components - 1
        return components - 1;
    }

    private void dfs(int node, List<Integer>[] adjList, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adjList[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor, adjList, visited);
            }
        }
    }
}
