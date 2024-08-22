import java.util.*;

class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        
        // Add all land cells to the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        // If there's no water or no land, return -1
        if (queue.size() == 0 || queue.size() == n * n) {
            return -1;
        }
        
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int maxDistance = -1;
        
        // BFS from all land cells
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];
            
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                
                // If the new cell is within bounds and is water (0)
                if (newX >= 0 && newX < n && newY >= 0 && newY < n && grid[newX][newY] == 0) {
                    // Update the distance and mark the cell as visited by setting it to 1
                    grid[newX][newY] = grid[x][y] + 1;
                    maxDistance = grid[newX][newY] - 1;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        
        return maxDistance;
    }
}
