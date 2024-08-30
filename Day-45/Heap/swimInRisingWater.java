
class Solution {
  public int swimInWater(int[][] grid) {
      int n = grid.length;
      PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
      boolean[][] visited = new boolean[n][n];
      pq.offer(new int[]{grid[0][0], 0, 0}); // {elevation, x, y}
      int[] directions = {-1, 0, 1, 0, -1};  // Directions for moving in 4 directions

      while (!pq.isEmpty()) {
          int[] current = pq.poll();
          int elevation = current[0];
          int x = current[1];
          int y = current[2];

          if (x == n - 1 && y == n - 1) {
              return elevation; // Reached the bottom-right corner
          }

          visited[x][y] = true;

          for (int i = 0; i < 4; i++) {
              int nx = x + directions[i];
              int ny = y + directions[i + 1];

              if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                  pq.offer(new int[]{Math.max(elevation, grid[nx][ny]), nx, ny});
              }
          }
      }

      return -1; // If no path is found (though, per problem constraints, there's always a path)
  }
}
