class Solution {
  public int minInsertions(String s) {
      int n = s.length();
      int[][] dp = new int[n][n];

      // Base case: Single letter palindromes
      for (int i = 0; i < n; i++) {
          dp[i][i] = 1;
      }

      // Build the dp array
      for (int length = 2; length <= n; length++) {
          for (int i = 0; i <= n - length; i++) {
              int j = i + length - 1;
              if (s.charAt(i) == s.charAt(j)) {
                  dp[i][j] = dp[i + 1][j - 1] + 2;
              } else {
                  dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
              }
          }
      }

      // Minimum insertions needed
      return n - dp[0][n - 1];
  }
}
