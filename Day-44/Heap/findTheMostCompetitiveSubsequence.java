class Solution {
  public int[] mostCompetitive(int[] nums, int k) {
      int[] result = new int[k];
      int index = 0;
      int n = nums.length;
      
      for (int i = 0; i < n; i++) {
          // While the stack (represented by index) is not empty,
          // and the current element is smaller than the last element in the stack,
          // and we can remove the last element without making it impossible to reach k elements,
          // pop the stack.
          while (index > 0 && nums[i] < result[index - 1] && n - i + index > k) {
              index--;
          }
          
          // If there is still space in the stack (i.e., less than k elements in the result),
          // add the current element.
          if (index < k) {
              result[index++] = nums[i];
          }
      }
      
      return result;
  }
}
