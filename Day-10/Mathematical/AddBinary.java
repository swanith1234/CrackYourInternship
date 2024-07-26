class Solution {
  public String addBinary(String a, String b) {
      // Initialize pointers for both strings
      int i = a.length() - 1;
      int j = b.length() - 1;
      
      StringBuilder result = new StringBuilder();
      int carry = 0;
      
      // Iterate until both strings are processed
      while (i >= 0 || j >= 0 || carry != 0) {
          int sum = carry;
          
          if (i >= 0) {
              sum += a.charAt(i) - '0'; // Convert char to int
              i--;
          }
          
          if (j >= 0) {
              sum += b.charAt(j) - '0'; // Convert char to int
              j--;
          }
          
          carry = sum / 2; // Calculate carry for next position
          result.append(sum % 2); // Append the current bit to the result
      }
      
      // The result is built in reverse order, so reverse it
      return result.reverse().toString();
  }
}