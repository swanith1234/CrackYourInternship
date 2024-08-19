class Solution {
  // Function to detect cycle in a directed graph.
  public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
      boolean[] visited = new boolean[V];
      boolean[] recStack = new boolean[V];
      
      // Check each vertex
      for (int i = 0; i < V; i++) {
          if (!visited[i]) {
              // If a cycle is found, return true
              if (isCyclicUtil(i, visited, recStack, adj)) {
                  return true;
              }
          }
      }
      // If no cycle is found, return false
      return false;
  }
  
  private boolean isCyclicUtil(int node, boolean[] visited, boolean[] recStack, ArrayList<ArrayList<Integer>> adj) {
      // Mark the current node as visited and add to the recursion stack
      visited[node] = true;
      recStack[node] = true;
      
      // Recur for all neighbors
      for (Integer neighbor : adj.get(node)) {
          // If the neighbor is not visited, recursively visit it
          if (!visited[neighbor] && isCyclicUtil(neighbor, visited, recStack, adj)) {
              return true;
          }
          // If the neighbor is in the recursion stack, a cycle is detected
          else if (recStack[neighbor]) {
              return true;
          }
      }
      
      // Remove the node from the recursion stack
      recStack[node] = false;
      return false;
  }
}
