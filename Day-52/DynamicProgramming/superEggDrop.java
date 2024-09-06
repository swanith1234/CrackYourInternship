class Solution {
  public int superEggDrop(int k, int n) {
      // dp[m][k] will be the number of floors we can check with m moves and k eggs.
      int[][] dp = new int[n + 1][k + 1];
      
      int m = 0;
      
      // Iterate until we find the minimum number of moves required.
      while (dp[m][k] < n) {
          m++;
          for (int j = 1; j <= k; j++) {
              // Use the recurrence relation:
              // dp[m][j] = 1 (current floor) + dp[m-1][j-1] (egg breaks) + dp[m-1][j] (egg doesn't break)
              dp[m][j] = dp[m - 1][j - 1] + dp[m - 1][j] + 1;
          }
      }
      
      return m;
  }
}
