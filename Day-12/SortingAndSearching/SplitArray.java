class Solution {
  public int splitArray(int[] nums, int k) {
      // Initialize binary search boundaries
      int left = getMax(nums);
      int right = getSum(nums);
      
      while (left < right) {
          int mid = left + (right - left) / 2;
          if (canSplit(nums, k, mid)) {
              right = mid; // Try for a smaller largest sum
          } else {
              left = mid + 1; // Increase the largest sum
          }
      }
      
      return left;
  }

  private int getMax(int[] nums) {
      int max = Integer.MIN_VALUE;
      for (int num : nums) {
          max = Math.max(max, num);
      }
      return max;
  }

  private int getSum(int[] nums) {
      int sum = 0;
      for (int num : nums) {
          sum += num;
      }
      return sum;
  }

  private boolean canSplit(int[] nums, int k, int maxSum) {
      int subarrayCount = 1;
      int currentSum = 0;
      
      for (int num : nums) {
          if (currentSum + num > maxSum) {
              subarrayCount++;
              currentSum = num;
              if (subarrayCount > k) {
                  return false;
              }
          } else {
              currentSum += num;
          }
      }
      
      return true;
  }
}
