class Solution {
  public String longestCommonPrefix(String[] strs) {
      if (strs == null || strs.length == 0) {
          return "";
      }

      // Initialize prefix to the first string
      String prefix = strs[0];

      // Iterate through the array of strings
      for (int i = 1; i < strs.length; i++) {
          // Update the prefix by comparing it with the current string
          while (strs[i].indexOf(prefix) != 0) {
              // Reduce the prefix by one character from the end
              prefix = prefix.substring(0, prefix.length() - 1);
              // If prefix is empty, there is no common prefix
              if (prefix.isEmpty()) {
                  return "";
              }
          }
      }
      return prefix;
  }
}
