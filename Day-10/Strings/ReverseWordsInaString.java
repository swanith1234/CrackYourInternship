class Solution {
  public String reverseWords(String s) {
      // Trim leading and trailing spaces
      s = s.trim();
      // Split the string by one or more spaces
      String[] words = s.split("\\s+");
      // Initialize a StringBuilder to construct the result
      StringBuilder result = new StringBuilder();
      
      // Iterate over the words in reverse order
      for (int i = words.length - 1; i >= 0; i--) {
          result.append(words[i]);
          if (i != 0) {
              result.append(" ");
          }
      }
      
      // Return the final reversed words string
      return result.toString();
  }
}