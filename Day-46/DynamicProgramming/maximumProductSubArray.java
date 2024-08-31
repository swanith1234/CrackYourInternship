class Solution {
  public int maxProduct(int[] nums) {
      // Initialize variables
      int maxProduct = nums[0];
      int minProduct = nums[0];
      int result = nums[0];
      
      // Iterate through the array starting from the second element
      for (int i = 1; i < nums.length; i++) {
          int current = nums[i];
          
          // If current number is negative, swap maxProduct and minProduct
          if (current < 0) {
              int temp = maxProduct;
              maxProduct = minProduct;
              minProduct = temp;
          }
          
          // Update maxProduct and minProduct
          maxProduct = Math.max(current, maxProduct * current);
          minProduct = Math.min(current, minProduct * current);
          
          // Update the global maximum product result
          result = Math.max(result, maxProduct);
      }
      
      return result;
  }
}
