class Solution {
  public int mergeStones(int[] stones, int k) {
      int n = stones.length;
      
      // If it's not possible to merge all stones into one pile, return -1
      if ((n - 1) % (k - 1) != 0) return -1;
      
      // Prefix sum array to quickly calculate the sum of any subarray
      int[] prefixSum = new int[n + 1];
      for (int i = 0; i < n; i++) {
          prefixSum[i + 1] = prefixSum[i] + stones[i];
      }
      
      // DP table: dp[i][j] is the minimum cost to merge piles from index i to j
      int[][][] dp = new int[n][n][k + 1];
      
      // Initialize the DP table
      for (int len = 2; len <= n; len++) { // len is the length of the subarray
          for (int i = 0; i + len <= n; i++) {
              int j = i + len - 1;
              for (int m = 2; m <= k; m++) { // Trying to merge into m piles
                  dp[i][j][m] = Integer.MAX_VALUE;
                  for (int mid = i; mid < j; mid += k - 1) {
                      dp[i][j][m] = Math.min(dp[i][j][m], dp[i][mid][1] + dp[mid + 1][j][m - 1]);
                  }
              }
              // If we want to merge this whole subarray into 1 pile
              dp[i][j][1] = dp[i][j][k] + (prefixSum[j + 1] - prefixSum[i]);
          }
      }
      
      // Return the cost to merge the whole array into 1 pile
      return dp[0][n - 1][1];
  }
}
