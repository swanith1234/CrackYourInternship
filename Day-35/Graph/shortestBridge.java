import java.util.*;

class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        boolean found = false;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        
        // Find the first island and mark all its 1's
        for (int i = 0; i < n; i++) {
            if (found) break;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, queue, visited);
                    found = true;
                    break;
                }
            }
        }
        
        // BFS to find the shortest bridge to the second island
        int steps = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] cell = queue.poll();
                int x = cell[0];
                int y = cell[1];
                
                for (int[] dir : directions) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    
                    if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                        if (grid[nx][ny] == 1) {
                            return steps;
                        }
                        queue.offer(new int[] {nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            steps++;
        }
        
        return -1; // This return statement should never be reached
    }
    
    private void dfs(int[][] grid, int i, int j, Queue<int[]> queue, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] == 0) {
            return;
        }
        
        visited[i][j] = true;
        queue.offer(new int[] {i, j});
        
        dfs(grid, i + 1, j, queue, visited);
        dfs(grid, i - 1, j, queue, visited);
        dfs(grid, i, j + 1, queue, visited);
        dfs(grid, i, j - 1, queue, visited);
    }
}
