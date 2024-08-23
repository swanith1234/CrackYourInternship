class Solution {
  public void shortest_distance(int[][] matrix) {
      int n = matrix.length;
      
      // Initialize the matrix, replacing -1 with a large number for unreachable paths
      for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
              if (matrix[i][j] == -1 && i != j) {
                  matrix[i][j] = Integer.MAX_VALUE;
              }
          }
      }
      
      // Floyd-Warshall Algorithm
      for (int k = 0; k < n; k++) {
          for (int i = 0; i < n; i++) {
              for (int j = 0; j < n; j++) {
                  if (matrix[i][k] != Integer.MAX_VALUE && matrix[k][j] != Integer.MAX_VALUE) {
                      matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                  }
              }
          }
      }
      
      // Replace large values with -1 to indicate no path exists
      for (int i = 0; i < n; i++) {
          for (int j = 0; j < n; j++) {
              if (matrix[i][j] == Integer.MAX_VALUE) {
                  matrix[i][j] = -1;
              }
          }
      }
  }
}
