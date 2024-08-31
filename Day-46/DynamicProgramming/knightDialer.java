class Solution {
  private static final int MOD = 1000000007;

  public int knightDialer(int n) {
      if (n == 1) return 10;
      
      // Moves that a knight can make from each digit
      int[][] moves = {
          {4, 6}, // 0 -> {4, 6}
          {6, 8}, // 1 -> {6, 8}
          {7, 9}, // 2 -> {7, 9}
          {4, 8}, // 3 -> {4, 8}
          {0, 3, 9}, // 4 -> {0, 3, 9}
          {},    // 5 has no moves (this is unreachable directly)
          {0, 1, 7}, // 6 -> {0, 1, 7}
          {2, 6}, // 7 -> {2, 6}
          {1, 3}, // 8 -> {1, 3}
          {2, 4}  // 9 -> {2, 4}
      };
      
      // dp[i][j] -> number of ways to reach digit j with a number of length i
      int[][] dp = new int[n + 1][10];
      
      // Base case: for length 1, there's exactly 1 way to form each digit
      for (int i = 0; i <= 9; i++) {
          dp[1][i] = 1;
      }
      
      // Fill dp array for lengths 2 to n
      for (int i = 2; i <= n; i++) {
          for (int j = 0; j <= 9; j++) {
              dp[i][j] = 0;
              for (int move : moves[j]) {
                  dp[i][j] = (dp[i][j] + dp[i - 1][move]) % MOD;
              }
          }
      }
      
      // Sum up all ways to form a number of length n
      int result = 0;
      for (int i = 0; i <= 9; i++) {
          result = (result + dp[n][i]) % MOD;
      }
      
      return result;
  }
}
