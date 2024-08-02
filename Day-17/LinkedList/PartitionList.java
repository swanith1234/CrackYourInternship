
class Solution {
  public ListNode partition(ListNode head, int x) {
      // Create two dummy nodes to start the less and greater lists
      ListNode lessDummy = new ListNode(0);
      ListNode greaterDummy = new ListNode(0);
      
      // Pointers to build the new lists
      ListNode less = lessDummy;
      ListNode greater = greaterDummy;
      
      // Traverse the original list
      ListNode current = head;
      while (current != null) {
          if (current.val < x) {
              less.next = current;
              less = less.next;
          } else {
              greater.next = current;
              greater = greater.next;
          }
          current = current.next;
      }
      
      // Combine the two lists
      greater.next = null; // Ensure the last node points to null
      less.next = greaterDummy.next; // Connect the less list to the greater list
      
      return lessDummy.next; // The head of the new partitioned list
  }
}