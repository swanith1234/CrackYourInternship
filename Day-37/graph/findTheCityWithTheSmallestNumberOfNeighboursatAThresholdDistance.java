class Solution {
  public int findTheCity(int n, int[][] edges, int distanceThreshold) {
      int[][] dist = new int[n][n];
      
      // Initialize the distance matrix
      for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
              if (i == j) {
                  dist[i][j] = 0;
              } else {
                  dist[i][j] = Integer.MAX_VALUE / 2; // Use a large value to avoid overflow
              }
          }
      }
      
      // Fill in the distances based on the edges
      for (int[] edge : edges) {
          int u = edge[0];
          int v = edge[1];
          int w = edge[2];
          dist[u][v] = w;
          dist[v][u] = w;
      }
      
      // Floyd-Warshall Algorithm
      for (int k = 0; k < n; k++) {
          for (int i = 0; i < n; i++) {
              for (int j = 0; j < n; j++) {
                  if (dist[i][k] + dist[k][j] < dist[i][j]) {
                      dist[i][j] = dist[i][k] + dist[k][j];
                  }
              }
          }
      }
      
      // Determine the city with the smallest number of reachable cities
      int minReachableCities = Integer.MAX_VALUE;
      int cityWithMinReachable = -1;
      
      for (int i = 0; i < n; i++) {
          int reachableCities = 0;
          for (int j = 0; j < n; j++) {
              if (i != j && dist[i][j] <= distanceThreshold) {
                  reachableCities++;
              }
          }
          
          // If the current city has fewer or the same number of reachable cities
          // but a higher index, update the result.
          if (reachableCities <= minReachableCities) {
              minReachableCities = reachableCities;
              cityWithMinReachable = i;
          }
      }
      
      return cityWithMinReachable;
  }
}
