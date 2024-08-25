class Solution {
  public int removeBoxes(int[] boxes) {
      int n = boxes.length;
      int[][][] dp = new int[n][n][n];
      return helper(boxes, 0, n - 1, 0, dp);
  }

  private int helper(int[] boxes, int l, int r, int k, int[][][] dp) {
      if (l > r) return 0;
      if (dp[l][r][k] != 0) return dp[l][r][k];

      // Expand the block of the same color as much as possible
      while (l + 1 <= r && boxes[l] == boxes[l + 1]) {
          l++;
          k++;
      }
      
      // Calculate points for removing the initial block
      dp[l][r][k] = (k + 1) * (k + 1) + helper(boxes, l + 1, r, 0, dp);

      // Try to merge with subsequent blocks of the same color
      for (int i = l + 1; i <= r; i++) {
          if (boxes[i] == boxes[l]) {
              dp[l][r][k] = Math.max(dp[l][r][k], helper(boxes, l + 1, i - 1, 0, dp) + helper(boxes, i, r, k + 1, dp));
          }
      }

      return dp[l][r][k];
  }
}
