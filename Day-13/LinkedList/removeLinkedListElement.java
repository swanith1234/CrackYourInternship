
class Solution {
  public ListNode removeElements(ListNode head, int val) {
      // Create a dummy node
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      
      // Pointer to traverse the list
      ListNode current = dummy;
      
      while (current.next != null) {
          if (current.next.val == val) {
              // Skip the node with the value to remove
              current.next = current.next.next;
          } else {
              // Move to the next node
              current = current.next;
          }
      }
      
      return dummy.next;
  }
}
