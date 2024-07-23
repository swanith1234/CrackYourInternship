public class Solution {
  public boolean canJump(int[] nums) {
      int furthest = 0;  // Furthest index we can reach
      
      for (int i = 0; i < nums.length; i++) {
          // If current index is beyond the furthest point we can reach, return false
          if (i > furthest) {
              return false;
          }
          // Update the furthest point we can reach from current index
          furthest = Math.max(furthest, i + nums[i]);
          // If we can reach the last index, return true
          if (furthest >= nums.length - 1) {
              return true;
          }
      }
      
      return false;
  }
}
