class Solution {
  public int getDecimalValue(ListNode head) {
      int result = 0;
      ListNode current = head;
      
      while (current != null) {
          // Shift result to the left and add the current node's value
          result = (result << 1) | current.val;
          current = current.next;
      }
      
      return result;
  }
}