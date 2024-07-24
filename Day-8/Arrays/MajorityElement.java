class Solution {
  public int majorityElement(int[] nums) {
      int count = 0;
      Integer candidate = null;

      // Phase 1: Find a candidate for the majority element
      for (int num : nums) {
          if (count == 0) {
              candidate = num;
          }
          count += (num == candidate) ? 1 : -1;
      }

      // Phase 2: Verify the candidate
      count = 0;
      for (int num : nums) {
          if (num == candidate) {
              count++;
          }
      }

      if (count > nums.length / 2) {
          return candidate;
      } else {
          // As per the problem's constraint, this should never happen.
          throw new IllegalArgumentException("No majority element found");
      }
  }
}
