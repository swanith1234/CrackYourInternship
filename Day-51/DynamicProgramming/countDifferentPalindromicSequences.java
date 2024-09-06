class Solution {
  public int countPalindromicSubsequences(String s) {
      int n = s.length();
      int mod = 1000000007;

      // dp[i][j] will store the number of distinct palindromic subsequences in the substring s[i...j]
      int[][] dp = new int[n][n];

      // Base case: single character palindromes
      for (int i = 0; i < n; i++) {
          dp[i][i] = 1;
      }

      // Fill the dp table for substrings of length 2 to n
      for (int len = 2; len <= n; len++) {
          for (int i = 0; i <= n - len; i++) {
              int j = i + len - 1;
              if (s.charAt(i) == s.charAt(j)) {
                  int low = i + 1, high = j - 1;

                  // Find the range between s[i] and s[j] with the same character as s[i]
                  while (low <= high && s.charAt(low) != s.charAt(i)) low++;
                  while (low <= high && s.charAt(high) != s.charAt(j)) high--;

                  if (low > high) {
                      // No same characters inside, so we count dp[i+1][j-1] + 2 (for "aa" and "a_a")
                      dp[i][j] = dp[i + 1][j - 1] * 2 + 2;
                  } else if (low == high) {
                      // One same character inside, so we count dp[i+1][j-1] * 2 + 1 (one middle character)
                      dp[i][j] = dp[i + 1][j - 1] * 2 + 1;
                  } else {
                      // Two same characters inside, so we count dp[i+1][j-1] * 2 - dp[low+1][high-1]
                      dp[i][j] = dp[i + 1][j - 1] * 2 - dp[low + 1][high - 1];
                  }
              } else {
                  // Characters at i and j are different, we take the sum of subsequences
                  dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
              }

              // Handle modulo operation to avoid overflow and ensure non-negative result
              dp[i][j] = (dp[i][j] % mod + mod) % mod;
          }
      }

      // Result is the count of distinct palindromic subsequences in the entire string
      return dp[0][n - 1];
  }
}
