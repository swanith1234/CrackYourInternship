class Solution {
  public int trap(int[] height) {
      // Edge case: if there's no bar or only one bar, no water can be trapped.
      if (height == null || height.length == 0) return 0;
      
      int n = height.length;
      
      // Arrays to store the maximum heights on the left and right of each bar
      int[] leftMax = new int[n];
      int[] rightMax = new int[n];
      
      // Fill leftMax: scan from left to right
      leftMax[0] = height[0];
      for (int i = 1; i < n; i++) {
          leftMax[i] = Math.max(leftMax[i - 1], height[i]);
      }
      
      // Fill rightMax: scan from right to left
      rightMax[n - 1] = height[n - 1];
      for (int i = n - 2; i >= 0; i--) {
          rightMax[i] = Math.max(rightMax[i + 1], height[i]);
      }
      
      // Calculate the total trapped water
      int totalWater = 0;
      for (int i = 0; i < n; i++) {
          // Water trapped at position i is min(leftMax[i], rightMax[i]) - height[i]
          totalWater += Math.min(leftMax[i], rightMax[i]) - height[i];
      }
      
      return totalWater;
  }
}
