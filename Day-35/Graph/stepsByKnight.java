import java.util.*;

class Solution {
    // Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N) {
        // Directions for Knight's possible moves
        int[] dx = {2, 2, -2, -2, 1, -1, 1, -1};
        int[] dy = {1, -1, 1, -1, 2, 2, -2, -2};
        
        // Queue for BFS
        Queue<int[]> queue = new LinkedList<>();
        // Set to keep track of visited positions
        boolean[][] visited = new boolean[N + 1][N + 1];
        
        // Start BFS from the Knight's initial position
        queue.add(new int[]{KnightPos[0], KnightPos[1], 0});
        visited[KnightPos[0]][KnightPos[1]] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int steps = current[2];
            
            // If we reach the target position, return the number of steps
            if (x == TargetPos[0] && y == TargetPos[1]) {
                return steps;
            }
            
            // Explore all 8 possible moves of a Knight
            for (int i = 0; i < 8; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                
                // Check if the new position is within the bounds and not yet visited
                if (newX >= 1 && newY >= 1 && newX <= N && newY <= N && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.add(new int[]{newX, newY, steps + 1});
                }
            }
        }
        
        // If the target position is unreachable (shouldn't happen in a valid scenario)
        return -1;
    }
}
