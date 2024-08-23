import java.util.*;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];  // To keep track of visited squares
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);  // Start from square 1
        visited[1] = true;
        int moves = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == n * n) {
                    return moves;  // Reached the last square
                }
                
                // Check next 6 possible squares
                for (int next = curr + 1; next <= Math.min(curr + 6, n * n); next++) {
                    int[] pos = getBoardPosition(next, n);
                    int row = pos[0];
                    int col = pos[1];
                    int destination = board[row][col] == -1 ? next : board[row][col];
                    
                    if (!visited[destination]) {
                        visited[destination] = true;
                        queue.offer(destination);
                    }
                }
            }
            moves++;
        }
        
        return -1;  // If we can't reach the last square
    }
    
    private int[] getBoardPosition(int square, int n) {
        int row = (square - 1) / n;
        int col = (square - 1) % n;
        if (row % 2 == 1) {
            col = n - 1 - col;
        }
        return new int[]{n - 1 - row, col};
    }
}
