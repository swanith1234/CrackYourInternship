
class Solution {
  public int subarraysDivByK(int[] nums, int k) {
      // HashMap to store the frequency of remainders
      HashMap<Integer, Integer> remainderFrequency = new HashMap<>();
      // Initialize the frequency of remainder 0 as 1 (for the subarray starting from the beginning)
      remainderFrequency.put(0, 1);
      
      int sum = 0;
      int count = 0;
      
      // Iterate through the array
      for (int num : nums) {
          sum += num;
          
          // Calculate the remainder of the current prefix sum
          int remainder = sum % k;
          
          // Adjust negative remainders to be positive
          if (remainder < 0) {
              remainder += k;
          }
          
          // If this remainder has been seen before, it means there are subarrays
          // ending at the current index which have a sum divisible by k
          if (remainderFrequency.containsKey(remainder)) {
              count += remainderFrequency.get(remainder);
          }
          
          // Update the frequency of the current remainder
          remainderFrequency.put(remainder, remainderFrequency.getOrDefault(remainder, 0) + 1);
      }
      
      return count;
  }
}