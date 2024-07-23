public class Solution {
  public boolean exist(char[][] board, String word) {
      if (board == null || board.length == 0 || word == null || word.length() == 0) {
          return false;
      }
      
      int m = board.length;
      int n = board[0].length;
      
      for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
              if (dfs(board, word, i, j, 0)) {
                  return true;
              }
          }
      }
      
      return false;
  }
  
  private boolean dfs(char[][] board, String word, int i, int j, int index) {
      // Base case: check if we've completed the word
      if (index == word.length()) {
          return true;
      }
      
      // Check boundaries and character match
      if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
          return false;
      }
      
      // Mark the cell as visited by storing its value and then setting it to a placeholder
      char temp = board[i][j];
      board[i][j] = '#';
      
      // Explore all possible directions: up, down, left, right
      boolean found = dfs(board, word, i + 1, j, index + 1) ||
                      dfs(board, word, i - 1, j, index + 1) ||
                      dfs(board, word, i, j + 1, index + 1) ||
                      dfs(board, word, i, j - 1, index + 1);
      
      // Restore the cell value
      board[i][j] = temp;
      
      return found;
  }
}
