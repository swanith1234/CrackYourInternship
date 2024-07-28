
class Solution {
  public List<Integer> countSmaller(int[] nums) {
      // Result array to store the counts
      Integer[] result = new Integer[nums.length];
      // Auxiliary array to store indices
      int[] indices = new int[nums.length];
      
      for (int i = 0; i < nums.length; i++) {
          indices[i] = i;
          result[i] = 0;
      }
      
      mergeSort(nums, indices, result, 0, nums.length - 1);
      return Arrays.asList(result);
  }
  
  private void mergeSort(int[] nums, int[] indices, Integer[] result, int left, int right) {
      if (left >= right) return;
      
      int mid = left + (right - left) / 2;
      mergeSort(nums, indices, result, left, mid);
      mergeSort(nums, indices, result, mid + 1, right);
      
      merge(nums, indices, result, left, mid, right);
  }
  
  private void merge(int[] nums, int[] indices, Integer[] result, int left, int mid, int right) {
      int[] temp = new int[right - left + 1];
      int i = left, j = mid + 1, k = 0;
      int rightCounter = 0;
      
      while (i <= mid && j <= right) {
          if (nums[indices[j]] < nums[indices[i]]) {
              temp[k++] = indices[j++];
              rightCounter++;
          } else {
              result[indices[i]] += rightCounter;
              temp[k++] = indices[i++];
          }
      }
      
      while (i <= mid) {
          result[indices[i]] += rightCounter;
          temp[k++] = indices[i++];
      }
      
      while (j <= right) {
          temp[k++] = indices[j++];
      }
      
      for (i = left, k = 0; i <= right; i++, k++) {
          indices[i] = temp[k];
      }
  }
}
