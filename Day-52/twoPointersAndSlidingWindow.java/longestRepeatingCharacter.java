class Solution {
  public int characterReplacement(String s, int k) {
      int[] count = new int[26];  // To store the frequency of each character
      int left = 0;
      int maxCount = 0;  // Maximum frequency of a single character in the current window
      int maxLength = 0;  // To store the length of the longest valid window
      
      for (int right = 0; right < s.length(); right++) {
          // Update the count of the current character
          count[s.charAt(right) - 'A']++;
          
          // Update the maxCount to be the maximum frequency of any single character in the current window
          maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);
          
          // If the current window size minus the maxCount exceeds k, it means we need more than k replacements
          if ((right - left + 1) - maxCount > k) {
              // Shrink the window from the left
              count[s.charAt(left) - 'A']--;
              left++;
          }
          
          // Calculate the maximum valid window size
          maxLength = Math.max(maxLength, right - left + 1);
      }
      
      return maxLength;
  }
}
