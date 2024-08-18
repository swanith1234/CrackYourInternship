class Solution {
  public int numIslands(char[][] grid) {
      if (grid == null || grid.length == 0) {
          return 0;
      }
      
      int numIslands = 0;
      int m = grid.length;
      int n = grid[0].length;
      
      for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
              if (grid[i][j] == '1') {
                  numIslands += 1;
                  dfs(grid, i, j);
              }
          }
      }
      
      return numIslands;
  }
  
  private void dfs(char[][] grid, int i, int j) {
      int m = grid.length;
      int n = grid[0].length;
      
      // Check for the boundary conditions and if the current cell is water or already visited
      if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
          return;
      }
      
      // Mark the current cell as visited
      grid[i][j] = '0';
      
      // Traverse the adjacent cells (left, right, up, down)
      dfs(grid, i + 1, j); // down
      dfs(grid, i - 1, j); // up
      dfs(grid, i, j + 1); // right
      dfs(grid, i, j - 1); // left
  }
}
