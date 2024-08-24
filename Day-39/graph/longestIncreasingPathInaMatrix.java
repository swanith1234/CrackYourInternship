class Solution {
  private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
  private int[][] memo;

  public int longestIncreasingPath(int[][] matrix) {
      if (matrix == null || matrix.length == 0) return 0;
      
      int m = matrix.length, n = matrix[0].length;
      memo = new int[m][n];
      int maxLen = 0;
      
      for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
              maxLen = Math.max(maxLen, dfs(matrix, i, j, m, n));
          }
      }
      
      return maxLen;
  }

  private int dfs(int[][] matrix, int i, int j, int m, int n) {
      if (memo[i][j] != 0) return memo[i][j];
      
      int maxLen = 1;
      for (int[] dir : directions) {
          int x = i + dir[0], y = j + dir[1];
          if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
              int len = 1 + dfs(matrix, x, y, m, n);
              maxLen = Math.max(maxLen, len);
          }
      }
      
      memo[i][j] = maxLen;
      return maxLen;
  }
}
