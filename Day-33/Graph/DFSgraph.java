class Solution {
  // Function to return a list containing the DFS traversal of the graph.
  public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
      ArrayList<Integer> dfsResult = new ArrayList<>();
      boolean[] visited = new boolean[V];
      
      // Start DFS from vertex 0
      dfs(0, adj, visited, dfsResult);
      
      return dfsResult;
  }
  
  // Recursive DFS function
  private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> dfsResult) {
      visited[node] = true;
      dfsResult.add(node);
      
      // Traverse all the adjacent vertices
      for (int adjacent : adj.get(node)) {
          if (!visited[adjacent]) {
              dfs(adjacent, adj, visited, dfsResult);
          }
      }
  }
}
