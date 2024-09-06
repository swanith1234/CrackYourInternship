class Solution {
  static int equalPartition(int N, int arr[]) {
      // Calculate the total sum of the array
      int sum = 0;
      for (int num : arr) {
          sum += num;
      }
      
      // If the sum is odd, we cannot partition it into two equal parts
      if (sum % 2 != 0) {
          return 0;
      }
      
      // We need to find if there's a subset with sum equal to sum / 2
      int target = sum / 2;
      
      // DP array to store the possible sums we can form
      boolean[] dp = new boolean[target + 1];
      dp[0] = true;  // A sum of 0 is always possible (with an empty subset)
      
      // Update the dp array
      for (int num : arr) {
          for (int j = target; j >= num; j--) {
              dp[j] = dp[j] || dp[j - num];
          }
      }
      
      // If we can form the target sum, return 1, else return 0
      return dp[target] ? 1 : 0;
  }
}
