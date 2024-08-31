class Solution {
  public int findMaxForm(String[] strs, int m, int n) {
      // DP array to store the maximum number of strings for each combination of m and n
      int[][] dp = new int[m + 1][n + 1];
      
      // Iterate over each string in the array
      for (String str : strs) {
          // Count the number of 0's and 1's in the current string
          int count0 = 0, count1 = 0;
          for (char c : str.toCharArray()) {
              if (c == '0') count0++;
              else count1++;
          }
          
          // Update the DP array in reverse order
          for (int i = m; i >= count0; i--) {
              for (int j = n; j >= count1; j--) {
                  dp[i][j] = Math.max(dp[i][j], dp[i - count0][j - count1] + 1);
              }
          }
      }
      
      // The value in dp[m][n] will be the answer
      return dp[m][n];
  }
}
