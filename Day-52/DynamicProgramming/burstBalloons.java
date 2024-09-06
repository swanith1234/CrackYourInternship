class Solution {
  public int maxCoins(int[] nums) {
      int n = nums.length;
      
      // Create a new array with boundary balloons (1) at both ends
      int[] newNums = new int[n + 2];
      newNums[0] = 1;
      newNums[n + 1] = 1;
      for (int i = 0; i < n; i++) {
          newNums[i + 1] = nums[i];
      }
      
      // DP array to store the maximum coins obtained for bursting balloons
      int[][] dp = new int[n + 2][n + 2];
      
      // Build the DP table
      for (int length = 2; length <= n + 1; length++) {
          for (int left = 0; left <= n + 1 - length; left++) {
              int right = left + length;
              for (int k = left + 1; k < right; k++) {
                  dp[left][right] = Math.max(dp[left][right], 
                      newNums[left] * newNums[k] * newNums[right] + dp[left][k] + dp[k][right]);
              }
          }
      }
      
      // The answer is the maximum coins for the range (0, n+1)
      return dp[0][n + 1];
  }
}
