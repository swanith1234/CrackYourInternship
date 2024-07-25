class Solution {
  public int strStr(String haystack, String needle) {
      // If needle is an empty string, return 0
      if (needle.isEmpty()) {
          return 0;
      }

      // Find the first occurrence of needle in haystack
      return haystack.indexOf(needle);
  }
}
