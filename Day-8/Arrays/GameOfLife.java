class Solution {
  public void gameOfLife(int[][] board) {
      if (board == null || board.length == 0) return;
      
      int m = board.length;
      int n = board[0].length;
      
      // Iterate through board cell by cell.
      for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
              // Count the live neighbors.
              int liveNeighbors = countLiveNeighbors(board, i, j);
              
              // Rule 1 or Rule 3
              if ((board[i][j] & 1) == 1) {
                  if (liveNeighbors < 2 || liveNeighbors > 3) {
                      // Mark the cell as dead in the next state.
                      board[i][j] &= ~2; // Set the 2nd bit to 0.
                  } else {
                      // Rule 2
                      // Mark the cell as live in the next state.
                      board[i][j] |= 2; // Set the 2nd bit to 1.
                  }
              } else {
                  // Rule 4
                  if (liveNeighbors == 3) {
                      // Mark the cell as live in the next state.
                      board[i][j] |= 2; // Set the 2nd bit to 1.
                  }
              }
          }
      }
      
      // Update the board to the next state.
      for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
              board[i][j] >>= 1; // Right shift to get the next state.
          }
      }
  }
  
  private int countLiveNeighbors(int[][] board, int row, int col) {
      int count = 0;
      int m = board.length;
      int n = board[0].length;
      
      // Define the 8 possible directions.
      int[][] directions = {
          {-1, -1}, {-1, 0}, {-1, 1},
          { 0, -1},         { 0, 1},
          { 1, -1}, { 1, 0}, { 1, 1}
      };
      
      for (int[] direction : directions) {
          int newRow = row + direction[0];
          int newCol = col + direction[1];
          
          // Check the boundaries and add the live cells.
          if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
              count += (board[newRow][newCol] & 1);
          }
      }
      
      return count;
  }
}
