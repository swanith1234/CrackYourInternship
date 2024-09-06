class Solution {
  public int deleteAndEarn(int[] nums) {
      if (nums == null || nums.length == 0) {
          return 0;
      }
      
      // Step 1: Find the maximum value in nums to determine the range of our dp array
      int max = 0;
      for (int num : nums) {
          max = Math.max(max, num);
      }
      
      // Step 2: Create an array to store points for each number
      int[] points = new int[max + 1];
      for (int num : nums) {
          points[num] += num; // Accumulate points for each number
      }
      
      // Step 3: Use dynamic programming to find the maximum points
      int[] dp = new int[max + 1];
      dp[0] = points[0];
      if (max >= 1) {
          dp[1] = Math.max(points[0], points[1]);
      }
      
      for (int i = 2; i <= max; i++) {
          dp[i] = Math.max(dp[i - 1], dp[i - 2] + points[i]);
      }
      
      return dp[max];
  }
}
