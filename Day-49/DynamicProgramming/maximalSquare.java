class Solution {
  public int maximalSquare(char[][] matrix) {
      if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
          return 0;
      }
      
      int m = matrix.length;
      int n = matrix[0].length;
      int[][] dp = new int[m][n];
      int maxSide = 0;
      
      // Fill the dp table
      for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
              if (matrix[i][j] == '1') {
                  // If we're in the first row or first column
                  if (i == 0 || j == 0) {
                      dp[i][j] = 1;
                  } else {
                      dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                  }
                  // Update the maximum side length
                  maxSide = Math.max(maxSide, dp[i][j]);
              }
          }
      }
      
      // Return the area of the largest square
      return maxSide * maxSide;
  }
}
